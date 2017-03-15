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
public class TelnetEchoThird {

    public static void main(String[] args) {

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
            System.out.println("started at " + address);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                int selectedNum = selector.select();
                System.out.println("Selected Number is : " + selectedNum);
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey selectedKey = iter.next();
                    if ((selectedKey.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                        System.out.println("这是一个连接...");
                        ServerSocketChannel serverChannel = (ServerSocketChannel) selectedKey.channel();
                        SocketChannel socketChannel = serverChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        socketChannel.write(ByteBuffer.wrap("Welcome Leader.us Power Man Java Course.....\r\n ".getBytes()));
                    } else if ((selectedKey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                        System.out.println("received read event");
                        SocketChannel socketChannel = (SocketChannel) selectedKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        socketChannel.read(buffer);
                        buffer = (ByteBuffer) selectedKey.attachment();
                        if(buffer == null || !buffer.hasRemaining()){
                            int dataLength = socketChannel.socket().getSendBufferSize()*50;
                            buffer = ByteBuffer.allocate(dataLength);
                            for(int i=0;i<buffer.capacity()-2;i++){
                                buffer.put((byte)('a'+i%25));
                            }
                            buffer.flip();
                            System.out.println("send another huge block data "+dataLength);
                        }
                        int writed = socketChannel.write(buffer);
                        System.out.println("writed "+writed);
                        if(buffer.hasRemaining()){
                            System.out.println("not write finished bind to session "+buffer.remaining());
                            //buffer = buffer.compact();
                            buffer = buffer.slice();
                            selectedKey.attach(buffer);
                            //这里一定要重新注册感兴趣
                            selectedKey.interestOps(selectedKey.interestOps()|SelectionKey.OP_WRITE);
                        }else{
                            selectedKey.attach(null);
                            selectedKey.interestOps(selectedKey.interestOps() & ~SelectionKey.OP_WRITE);
                        }
                    }else if(selectedKey.isWritable()){
                        System.out.println("received write event ");
                        ByteBuffer buffer = (ByteBuffer) selectedKey.attachment();
                        SocketChannel socketChannel = (SocketChannel) selectedKey.channel();
                        if(buffer != null){
                            System.out.println("all count:"+buffer.remaining());
                            int writed = socketChannel.write(buffer);
                            System.out.println("writed "+writed );
                            if(buffer.hasRemaining()){
                                System.out.println("not write finished bind to session,remains "+buffer.remaining());
                                //buffer = buffer.compact();
                                buffer = buffer.slice();
                                selectedKey.attach(buffer);
                                //这里存在没有写完的数据，所以需要继续的写
                                selectedKey.interestOps(selectedKey.interestOps()|SelectionKey.OP_WRITE);
                            }else{
                                //只有writebuffer为空，始终可写，所以没数据可写的时候要取消写事件
                                selectedKey.attach(null);
                                selectedKey.interestOps(selectedKey.interestOps() & ~ selectedKey.OP_WRITE);
                            }
                        }
                    }
                    iter.remove();//这里一定要移除掉
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
