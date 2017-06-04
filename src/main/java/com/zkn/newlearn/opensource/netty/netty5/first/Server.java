package com.zkn.newlearn.opensource.netty.netty5.first;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by zkn on 2017/5/1.
 */
public class Server {

    public static void main(String[] args){

        //服务类
        ServerBootstrap bootstrap = new ServerBootstrap();
        //boss
        EventLoopGroup boss = new NioEventLoopGroup();
        //worker
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            bootstrap.group(boss,worker);
            //设置Socket工厂
            bootstrap.channel(NioServerSocketChannel.class);
            //设置处理类
            bootstrap.childHandler(new ChannelInitializer<Channel>() {

                @Override
                protected void initChannel(Channel channel) throws Exception {
                    channel.pipeline().addLast(new StringDecoder());
                    channel.pipeline().addLast(new StringEncoder());
                    channel.pipeline().addLast(new ServerHandler());
                }
            });
            //ServerSocketChannel的设置，设置缓冲区的大小
            bootstrap.option(ChannelOption.SO_BACKLOG,2048);
            //SocketChannel的设置，保持连接
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);
            //SocketChannel的设置 非延迟
            bootstrap.childOption(ChannelOption.TCP_NODELAY,true);
            //绑定端口
            ChannelFuture channelFuture = bootstrap.bind(10101);
            //关闭连接
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
