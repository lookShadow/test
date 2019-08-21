package com.cn.ouyjs;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author ouyjs
 * @date 2019/8/21 11:08
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        new NioClient().start();
    }

    public void start() throws IOException {
        //1. 连接服务器端
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8200));
        System.out.println("连接服务器成功!");
        //2.响应服务器端数据
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NioClientHandler(selector)).start();
        //3.向服务器端发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String request = scanner.nextLine();
            if (request!=null && request.length() > 0) {
                socketChannel.write(Charset.forName("utf-8").encode(request));
            }
        }

    }
}
