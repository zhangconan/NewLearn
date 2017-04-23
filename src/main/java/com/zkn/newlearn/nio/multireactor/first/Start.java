package com.zkn.newlearn.nio.multireactor.first;

import com.zkn.newlearn.nio.multireactor.first.pool.NioSelectorRunnablePool;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created by zkn on 2017/4/23.
 */
public class Start {

    public static void main(String[] args) {

        NioSelectorRunnablePool selectorRunnablePool = new NioSelectorRunnablePool(Executors.newCachedThreadPool(),Executors.newCachedThreadPool());
        ServerBootstrap serverBootstrap = new ServerBootstrap(selectorRunnablePool);
        serverBootstrap.bind(new InetSocketAddress(10009));
    }
}
