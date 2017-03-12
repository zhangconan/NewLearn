package com.zkn.newlearn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by zkn on 2017/3/9.
 */
public class TelnetEchoFirst {

    public static void main(String[] args){

        try {
            //启动一个Selector
            Selector selector = Selector.open();
            //启动一个服务端通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //非阻塞
            serverSocketChannel.configureBlocking(false);
            //设置端口号
            InetSocketAddress address = new InetSocketAddress(9000);
            serverSocketChannel.socket().bind(address);
            System.out.println("started at "+address);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                int selectedNum = selector.select();
                System.out.println("Selected Number is : " + selectedNum);
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()){
                    SelectionKey selectedKey = iter.next();
                    if((selectedKey.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
                        ServerSocketChannel serverChannel = (ServerSocketChannel) selectedKey.channel();
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                        socketChannel.write(ByteBuffer.wrap("Welcome Leader.us Power Man Java Course.....\r\n ".getBytes()));
                        iter.remove();//这里一定要移除掉
                    }else if((selectedKey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ){
                        SocketChannel socketChannel = (SocketChannel) selectedKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        buffer.put("\r\nFollow you:".getBytes());
                        socketChannel.read(buffer);
                        buffer.put("\r\n".getBytes());
                        buffer.flip();
                        socketChannel.write(buffer);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
