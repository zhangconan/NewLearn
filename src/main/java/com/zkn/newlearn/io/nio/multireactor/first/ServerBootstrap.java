package com.zkn.newlearn.io.nio.multireactor.first;

import com.zkn.newlearn.io.nio.multireactor.first.pool.NioSelectorRunnablePool;
import com.zkn.newlearn.io.nio.multireactor.first.pool.Boss;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by zkn on 2017/4/23.
 */
public class ServerBootstrap {

    private NioSelectorRunnablePool selectorRunnablePool;

    public ServerBootstrap(NioSelectorRunnablePool selectorRunnablePool) {
        this.selectorRunnablePool = selectorRunnablePool;
    }

    public void bind(InetSocketAddress inetSocketAddress) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //设置为非阻塞的
            serverSocketChannel.configureBlocking(false);
            //绑定端口号
            serverSocketChannel.socket().bind(inetSocketAddress);
            //获取一个boss线程
            Boss boss = selectorRunnablePool.getNextBoss();
            //注册连接事件
            boss.registerAcceptChannelTask(serverSocketChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
