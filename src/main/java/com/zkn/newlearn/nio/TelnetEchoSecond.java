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
public class TelnetEchoSecond {

    public static void main(String[] args){

        try {
            //启动一个Selector
            Selector selector = Selector.open();
            //启动一个服务端通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //非阻塞
            serverSocketChannel.configureBlocking(false);
            //设置端口号
            InetSocketAddress address = new InetSocketAddress(9001);
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
                        System.out.println("received read event");
                        SocketChannel socketChannel = (SocketChannel) selectedKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        socketChannel.read(buffer);
                        int writeBufferSize = socketChannel.socket().getSendBufferSize();
                        System.out.println("send buffer size:"+writeBufferSize);
                        buffer = ByteBuffer.allocate(writeBufferSize*50+2);
                        for(int i=0;i<buffer.capacity()-2;i++){
                            buffer.put((byte)('a'+i%25));
                        }
                        buffer.put("\r\n".getBytes());
                        buffer.flip();
                        int writed = socketChannel.write(buffer);
                        System.out.println("wited:"+writed);
                        if(buffer.hasRemaining()){
                            System.out.println("not write finished,remains "+buffer.remaining());
                        }
                        iter.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
