package com.zkn.newlearn.io.aio.first;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author zkn
 * @date 2018/5/3
 */
public class AsyncTimeServerHandler implements Runnable {

    private int port;

    private CountDownLatch latch;

    private AsynchronousServerSocketChannel socketChannel;

    public AsyncTimeServerHandler(int port) {
        this.port = port;
    }

    @Override
    public void run() {

    }
}
