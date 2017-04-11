package com.zkn.newlearn.netty.first;


import org.jboss.netty.bootstrap.ServerBootstrap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zkn on 2017/4/12.
 * netty服务端
 */
public class Server {
    public static void main(String[] args){
        //服务类
        ServerBootstrap bootstrap = new ServerBootstrap();

        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        //设置nioSocket工厂
    }
}
