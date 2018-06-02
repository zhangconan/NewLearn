package com.zkn.newlearn.io.nio.multireactor.first;

import com.zkn.newlearn.io.nio.multireactor.first.pool.NioSelectorRunnablePool;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created by zkn on 2017/4/23.
 * 多Selector模型：
 *  可以有多个Acceptor和Selector，目前这个例子中只是用了一个Acceptor和多个Selector。
 *  思想是：
 *      在启动的时候注册一个Acceptor(NioServerBoss),这个注册过程是在ServerBootstrap中实现的，注册多个Reacto(NioServerWoker)。
 *      AbstractNioSelector不断的轮询取注册的事件，如果是连接事件，则在NioServerBoss中处理，如果是读写事件则在NioServerWorker中处理.
 *
 */
public class Start {

    public static void main(String[] args) {

        NioSelectorRunnablePool selectorRunnablePool = new NioSelectorRunnablePool(Executors.newCachedThreadPool(),Executors.newCachedThreadPool());
        ServerBootstrap serverBootstrap = new ServerBootstrap(selectorRunnablePool);
        serverBootstrap.bind(new InetSocketAddress(10009));
    }
}
