package com.zkn.newlearn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import org.junit.Test;

/**
 * Created by wb-zhangkenan on 2017/3/15.
 *
 * @author wb-zhangkenan
 * @date 2017/03/15
 */
public class SocketChannelLearnFir {

    /**
     * 服务端
     */
    @Test
    public void server(){
        try {
            //创建服务器通道
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            //绑定端口号
            serverChannel.bind(new InetSocketAddress(9898));
            //创建选择器
            Selector selector = Selector.open();
            //非阻塞模式
            serverChannel.configureBlocking(false);
            //注册选择器
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                //就绪的通道的数量
                if(selector.select() == 0){
                    continue;
                }
                //获取选择键
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey selectKey = it.next();
                    //如果有就绪的连接
                    if((selectKey.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectKey.channel();
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        //注册读通道
                        socketChannel.register(selector,SelectionKey.OP_READ);
                        socketChannel.write(ByteBuffer.wrap("你好啊".getBytes()));
                    }
                    //处理就绪的读通道
                    if((selectKey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ){
                        //创建一个缓冲区
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        SocketChannel socketChannel = (SocketChannel)selectKey.channel();
                        socketChannel.configureBlocking(false);
                        int n = 0;
                        while ((n = socketChannel.read(buffer)) > 0){
                            buffer.flip();
                            System.out.println(new String(buffer.array(),0,n));
                            buffer.clear();
                        }
                    }
                    //这里一定要移除
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void client() throws IOException {
        //创建客户端的通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        //创建一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //设置为非阻塞模式
        socketChannel.configureBlocking(false);
        buffer.put("你好啊，服务端".getBytes());
        //切换到读模式
        buffer.flip();
        socketChannel.write(buffer);
        //切换到写模式
        buffer.clear();
        //关闭通道
        socketChannel.close();
    }
}
