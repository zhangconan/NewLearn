package com.zkn.newlearn.io.nio.threadpool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by wb-zhangkenan on 2017/3/16.
 *
 * @author wb-zhangkenan
 * @date 2017/03/16
 */
public class SocketChannelMain {

    public static void main(String[] args) {

        try {
            //连接器
            Selector selector = Selector.open();
            for (int i = 0; i < 10; i++) {
                //创建一个连接到9898端口的客户端通道
                SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
                //System.out.println(socketChannel.socket().toString());
                //设置为非阻塞模式
                socketChannel.configureBlocking(false);
                //注册连接事件 读事件
                socketChannel.register(selector, SelectionKey.OP_CONNECT|SelectionKey.OP_READ);
            }
            while (true) {
                //就绪的通道
                selector.select();
                //获取选择键
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey selectionKey = it.next();
                    if ((selectionKey.readyOps() & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT) {
                        System.out.println("我是客户端连接事件.....");
                        //获取连接通道
                        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                        //非阻塞模式
                        socketChannel.configureBlocking(false);
                        //注册读事件
                        socketChannel.register(selector,SelectionKey.OP_READ);
                        socketChannel.write(ByteBuffer.wrap(("连接成功了  "+socketChannel.socket().toString()).getBytes()));
                    }
                    if ((selectionKey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                        System.out.println("我是客户端读事件.....");
                        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                        System.out.println("我开始读数据了: "+socketChannel.socket().toString());
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        int flag = 0;
                        while((flag = socketChannel.read(buffer)) > 0){
                            buffer.flip();
                            System.out.println(new String(buffer.array()));
                            buffer.clear();
                        }
                        System.out.println("我读完了、、、、");
                        buffer.put(("我读完了："+socketChannel.socket().toString()).getBytes());
                        buffer.flip();
                        socketChannel.write(buffer);
                    }
                    if ((selectionKey.readyOps() & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE) {
                        System.out.println("我是客户端写事件.....");
                    }
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
