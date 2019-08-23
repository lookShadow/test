package com.cn.ouyjs.netty.secondexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author ouyjs
 * @date 2019/8/23 14:35
 */
public class MyServer {
    public static void main(String[] args) throws Exception{
        //循环接受客户端的请求并转发给workerGrooup
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        //循环处理对应事件的业务
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //服务启动器
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //添加分组 构建通道 childHandler处理实际的业务
            serverBootstrap.group(boosGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyServerInit());
            //绑定端口号
            ChannelFuture channelFuture = serverBootstrap.bind(8090).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
