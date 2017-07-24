package com.zkn.newlearn.nio.multireactor.first.pool;

import java.nio.channels.ServerSocketChannel;

/**
 * Created by zkn on 2017/4/23.
 */
public interface Boss {
    /**
     * 用来注册新的服务端
     * @param serverSocketChannel
     */
    void  registerAcceptChannelTask(ServerSocketChannel serverSocketChannel);
}
