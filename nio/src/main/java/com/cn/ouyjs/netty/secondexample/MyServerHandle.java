package com.cn.ouyjs.netty.secondexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author ouyjs
 * @date 2019/8/23 14:44
 */
public class MyServerHandle extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        Channel channel = channelHandlerContext.channel();
        System.out.println(channel.remoteAddress()+ ":: " + s);
        //写入并清除缓存中数据
        channel.writeAndFlush("from server 时间: "+System.currentTimeMillis());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        //关闭连接
        ctx.close();
    }
}
