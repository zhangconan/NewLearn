package com.zkn.newlearn.io.nio.multireactor.first.pool;

import java.nio.channels.SocketChannel;

/**
 * Created by zkn on 2017/4/23.
 */
public interface Worker {
    /**
     * 用来注册新连接的读写任务
     * @param socketChannel
     */
    void registerSocketChannlTask(SocketChannel socketChannel);
}
