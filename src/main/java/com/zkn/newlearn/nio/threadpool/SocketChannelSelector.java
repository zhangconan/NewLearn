package com.zkn.newlearn.nio.threadpool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wb-zhangkenan on 2017/3/16.
 *
 * @author wb-zhangkenan
 * @date 2017/03/16
 */
public class SocketChannelSelector {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        ServerSocketChannel serverSocketChannel = null;
        try {
            //创建一个服务器通道
            serverSocketChannel = ServerSocketChannel.open();
            //绑定一个端口号
            serverSocketChannel.bind(new InetSocketAddress(9898));
            //设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //创建选择器对象
            Selector selector = Selector.open();
            //注册Selector感兴趣的事件 这里注册的是连接事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                //选择就绪的通道，如果没有就绪的通道这里会一致阻塞
                selector.select();
                //获取选择键
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey selectionKey = it.next();
                    //如果有连接事件就绪
                    if ((selectionKey.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                        System.out.println("received accept event");
                        //服务器通道
                        ServerSocketChannel serverSocket = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = serverSocket.accept();
                        //非阻塞模式
                        socketChannel.configureBlocking(false);
                        //注册读事件
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        socketChannel.write(ByteBuffer.wrap("I am Server".getBytes()));
                    }
                    //如果有读事件就绪
                    if ((selectionKey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                        System.out.println("received read event");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        System.out.println(socketChannel.socket().toString());
                        //创建缓冲区
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        socketChannel.read(buffer);
                        executorService.execute(new ProcessReadEventThread(buffer,socketChannel));
//                        buffer.flip();
//                        socketChannel.write(buffer);
                    }
                    //如果有写事件就绪
                    if ((selectionKey.readyOps() & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        System.out.println(socketChannel.socket().toString());
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        socketChannel.write(buffer);
                    }
                    //这里一定要注意移除选择键
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭通道
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
