package com.zkn.newlearn.nio.threadpool.sec;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
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
    private SelectionKey selectionKey;
    private Selector selector;

    public ProcessReadEventThread(ByteBuffer byteBuffer, SocketChannel socketChannel,SelectionKey selectionKey,Selector selector) {
        this.byteBuffer = byteBuffer;
        this.socketChannel = socketChannel;
        this.selectionKey = selectionKey;
        this.selector = selector;
    }
    @Override
    public void run() {
        //run方法只对数据进行处理
        byteBuffer.flip();
        try {
            socketChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //重新注册读事件
        selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_READ);
        selector.wakeup();
    }
}
