package com.zkn.newlearn.opensource.netty.netty5.first;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by zkn on 2017/5/1.
 */
public class ServerHandler extends SimpleChannelInboundHandler {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.writeAndFlush("收到消息!");
        System.out.println(msg);
    }
}
