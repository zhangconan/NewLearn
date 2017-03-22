package com.zkn.newlearn.nio.threadpool.first;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Created by wb-zhangkenan on 2017/3/16.
 *
 * @author wb-zhangkenan
 * @date 2017/03/16
 */
public class ProcessWriteEventThread implements Runnable {

    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer;
    private SelectionKey selectionKey;

    public ProcessWriteEventThread(SocketChannel socketChannel, ByteBuffer byteBuffer, SelectionKey selectionKey) {
        this.socketChannel = socketChannel;
        this.byteBuffer = byteBuffer;
        this.selectionKey = selectionKey;
    }

    @Override
    public void run() {

    }
}
