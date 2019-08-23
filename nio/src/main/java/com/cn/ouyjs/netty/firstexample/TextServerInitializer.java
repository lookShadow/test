package com.cn.ouyjs.netty.firstexample;

import com.cn.ouyjs.netty.firstexample.TextHttpServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author ouyjs
 * @date 2019/8/22 17:39
 */
public class TextServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        channelPipeline.addLast("httpServerCodec", new HttpServerCodec());
        channelPipeline.addLast("textHttpServerHandler",new TextHttpServerHandler());
    }
}
