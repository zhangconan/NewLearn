package com.zkn.newlearn.nio.threadpool;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by wb-zhangkenan on 2017/3/16.
 *
 * @author wb-zhangkenan
 * @date 2017/03/16
 */
public class ProcessReadEventThread implements Runnable {

    private ByteBuffer byteBuffer;

    private SocketChannel socketChannel;

    public ProcessReadEventThread(ByteBuffer byteBuffer, SocketChannel socketChannel) {
        this.byteBuffer = byteBuffer;
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        byteBuffer.flip();
        try {
            socketChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
