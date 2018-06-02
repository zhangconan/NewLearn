package com.zkn.newlearn.io.nio.multireactor.first;

import com.zkn.newlearn.io.nio.multireactor.first.pool.NioSelectorRunnablePool;
import com.zkn.newlearn.io.nio.multireactor.first.pool.Worker;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/**
 * Created by zkn on 2017/4/23.
 */
public class NioServerWorker extends AbstractNioSelector implements Worker {

    public NioServerWorker(Executor executor, String threadName, NioSelectorRunnablePool selectorRunnablePool) {
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
        return selector.select(500);
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
            //这里一定要移除掉SelectionKey，要不然会空转
            it.remove();
            //这里处理的是读事件
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            socketChannel.configureBlocking(false);
            //因为目前注册的是只读的事件，所以这里处理的是可读事件
            if ((selectionKey.readyOps() & SelectionKey.OP_READ) != 0) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                //数据长度
                int length = 0;
                boolean disConnect = false;
                //有可读的事件
                try{
                    length = socketChannel.read(byteBuffer);
                }catch (Exception e){
                    disConnect = true;
                }
                //断开连接的时候，要取消选择键
                if(length <= 0 || disConnect){
                    selectionKey.cancel();
                    System.out.println("客户端断开连接");
                }else {
                    System.out.println("收到数据："+new String(byteBuffer.array()));
                    ByteBuffer buffer = ByteBuffer.wrap("收到".getBytes());
                    socketChannel.write(buffer);
                }
            }
        }
    }

    /**
     * 用来注册新连接的读写任务
     *
     * @param socketChannel
     */
    @Override
    public void registerSocketChannlTask(SocketChannel socketChannel) {
        Selector selector = this.selector;
        registerTask(() -> {
            try {
                socketChannel.register(selector, SelectionKey.OP_READ);
            } catch (ClosedChannelException e) {
                e.printStackTrace();
            }
        });
    }

}
