package com.zkn.newlearn.opensource.netty.third;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.time.LocalDateTime;

/**
 * @author zkn
 * @date 2018/6/11 22:41
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    private int counter;

    /**
     * 网络读事件处理
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //ByteBuf等于ByteBuffer
        ByteBuf buf = (ByteBuf) msg;
        //buf.readableBytes() 缓冲区中可读字节数。
        byte[] req = new byte[buf.readableBytes()];
        //读字节到byte数组中
        buf.readBytes(req);
        String body = new String(req, "UTF-8")
                .substring(0, req.length - System.getProperty("line.separator").length());
        System.out.println("The time server receive order:" + body + ";the counter is : " + ++counter);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? LocalDateTime.now().toString() : "BAD ORDER";
        currentTime += System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        //将要发送的消息发送到发送缓冲数组中
        ctx.write(resp);
    }

    /**
     * 读事件结束
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将消息发送队列中的消息写入到SocketChannel中发送给对象。
        ctx.flush();
    }

    /**
     * 异常处理
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
