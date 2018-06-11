package com.zkn.newlearn.opensource.netty.second;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author zkn
 * @date 2018/6/11 22:32
 */
public class TimeServer {

    private void bind(int port) {
        //NioEventLoopGroup是个线程组。专门用来处理NIO事件，实际上是Reactor线程组。
        //服务端接收客户端的连接。
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //用于SocketChannel的网络读写。
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //Netty启动NIO服务端的辅助启动类。
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    //NioServerSocketChannel对应于NIO中ServerSocketChannel
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //NIO处理类。
                    .childHandler(new ChildChannelHandler());
            //同步阻塞方法。
            ChannelFuture future = bootstrap.bind(port).sync();
            //等待服务端链路关闭之后 main函数才退出
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new TimeServer().bind(8080);
    }
}

