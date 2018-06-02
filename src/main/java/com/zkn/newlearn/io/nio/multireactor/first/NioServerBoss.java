package com.zkn.newlearn.io.nio.multireactor.first;

import com.zkn.newlearn.io.nio.multireactor.first.pool.Boss;
import com.zkn.newlearn.io.nio.multireactor.first.pool.NioSelectorRunnablePool;
import com.zkn.newlearn.io.nio.multireactor.first.pool.Worker;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/**
 * Created by zkn on 2017/4/23.
 */
public class NioServerBoss extends AbstractNioSelector implements Boss {

    public NioServerBoss(Executor executor, String threadName, NioSelectorRunnablePool selectorRunnablePool) {
        super(executor, threadName, selectorRunnablePool);
    }

    /**
     * select抽象方法
     *
     * @param selector
     * @return
     * @throws IOException
     */
    @Override
    protected int select(Selector selector) throws IOException {
        return selector.select();
    }

    /**
     * selector的业务处理
     *
     * @param selector
     * @throws IOException
     */
    @Override
    protected void process(Selector selector) throws IOException {
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        if (selectionKeys.isEmpty()) {
            return;
        }
        Iterator<SelectionKey> it = selectionKeys.iterator();
        while (it.hasNext()) {
            SelectionKey selectionKey = it.next();
            it.remove();
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            //获取一个Worker
            Worker worker = getSelectorRunnablePool().getNextWorker();
            //注册读事件
            worker.registerSocketChannlTask(socketChannel);
            System.out.println("有了一个新连接...");
        }
    }

    /**
     * 用来注册新的服务端
     *
     * @param serverSocketChannel
     */
    @Override
    public void registerAcceptChannelTask(ServerSocketChannel serverSocketChannel) {
        Selector selector = this.selector;
        registerTask(() -> {
            try {
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            } catch (ClosedChannelException e) {
                e.printStackTrace();
            }
        });
    }
}
