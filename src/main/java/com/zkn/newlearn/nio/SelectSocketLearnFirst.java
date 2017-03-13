package com.zkn.newlearn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Created by wb-zhangkenan on 2017/3/10.
 *
 * @author wb-zhangkenan
 * @date 2017/03/10
 */
public class SelectSocketLearnFirst {

    public static int PORT_NUMBER = 1234;

    public static void main(String[] args) {
        try {
            new SelectSocketLearnFirst().go(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void go(String[] args) throws Exception {
        int port = PORT_NUMBER;
        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        System.out.println("Listening on port " + port);
        //创建一个ServerSocket通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        //创建一个ServerSocket
        ServerSocket serverSocket = serverChannel.socket();
        //创建一个选择器
        Selector selector = Selector.open();
        //绑定要监听的端口号
        serverSocket.bind(new InetSocketAddress(port));
        //将通道设置为非阻塞
        serverChannel.configureBlocking(false);
        //为ServerSocket通道注册选择键
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //从上一个select()调用之后进入就绪状态的通道的数量
            //这种调用在没有通道就绪时将无限阻塞。一旦至少有一个已注册的通道就绪，
            //选择器的选择键就会被更新，并且每个就绪的通道的ready集合也将被更新。
            //返回值将会是已经确定就绪的通道的数目。
            int n = selector.select();
            if (n == 0) {
                continue;
            }
            //获取就绪的选择键
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                //如果有新的连接
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    registerChannel(selector, channel, SelectionKey.OP_READ);
                    sayHello(channel);
                }
                //如果有数据可读
                if (key.isReadable()) {
                    readDataFromSocket(key);
                }
                it.remove();
            }
        }
    }

    private void sayHello(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put("Hi there!\r\n".getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer = null;
    }

    private void readDataFromSocket(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int count;
        buffer.put("\r\nFollow My:".getBytes());
        while ((count = socketChannel.read(buffer)) > 0) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            buffer.clear();
            buffer.put("\r\n".getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        if (count < 0) {
            socketChannel.close();
        }
        buffer = null;
        System.out.println("完毕");
    }

    private void registerChannel(Selector selector, SelectableChannel channel, int ops) throws Exception {
        if (channel == null) {
            return;
        }
        //将通道设置为非阻塞
        channel.configureBlocking(false);
        channel.register(selector, ops);
    }
}
