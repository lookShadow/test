package com.cn.ouyjs;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ouyjs
 * @date 2019/8/21 10:24
 * nio服务器端
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
            new NioServer().start();
    }

    /**
     * 服务端启动方法
     * @throws IOException
     */
    public void start() throws IOException {
        //1.创建selector
        Selector selector = Selector.open();
        //2.建立serverSocketChannel通道
        ServerSocketChannel channel = ServerSocketChannel.open();
        //3.为channel通道绑定端口号
        channel.bind(new InetSocketAddress(8200));
        //4.将channel通道设置为非阻塞模式
        channel.configureBlocking(false);
        //5.channel注册到selector,监听连接事件
        channel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动成功!");
        //6.循环等待新接入的连接
        for(;;) {
            int count = selector.select();
            if (count == 0) {
                continue;
            }
            //获取连接的selectionKey  一个selectionKey对应一个channel通道 也就是说获取连接的通道
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator iterator = selectionKeySet.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                //移除set中当前的通道
                iterator.remove();
                //7.根据就绪状态调用对应方法处理业务逻辑
                //处理接入事件
                if (selectionKey.isAcceptable()) {
                    acceptHandler(channel, selector);
                }
                //处理可读事件
                if (selectionKey.isReadable()) {
                    readHandler(selectionKey, selector);
                }
            }
        }
    }

    public void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        //从当前channel中获取客户端连接的通道
        SocketChannel socketChannel = serverSocketChannel.accept();
        //将客户端channel通道设置非阻塞模式
        socketChannel.configureBlocking(false);
        //将客户端通道注册带selector并设置为可读模式
        socketChannel.register(selector, SelectionKey.OP_READ);
        //向连接的客户端发送信息
        socketChannel.write(Charset.forName("utf-8").encode("你与聊天室其他人都不是好友关系,请注意隐私安全"));
    }

    public void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        //获取当前就绪状态为可读的客户端通道
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        //创建byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String request = "";
        //从通道读取内容
        while (socketChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            request += Charset.forName("utf-8").decode(byteBuffer);
        }
        //将客户端通道注册到selector中
        socketChannel.register(selector, SelectionKey.OP_READ);
        if (!StringUtils.isEmpty(request)) {
            //广播给其他客户端
            broadCast(selector, socketChannel, request);
        }
    }

    private void broadCast(Selector selector,SocketChannel socketChannel,String request) throws IOException {
        //已注册到selection的SelectionKey
        Set<SelectionKey>  selectionKeySet = selector.keys();
        Iterator iterator = selectionKeySet.iterator();
        while (iterator.hasNext()) {
            SelectionKey selectionKey= (SelectionKey) iterator.next();
            Channel channel =  selectionKey.channel();
            //过滤当前通道
            if (channel instanceof SocketChannel && channel != socketChannel) {
                ((SocketChannel)channel).write(Charset.forName("utf-8").encode(request));
            }
        }
    }
}
