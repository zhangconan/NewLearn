package com.zkn.newlearn.opensource.netty.first;

/**
 * Created by zkn on 2017/4/12.
 * netty服务端
 */
public class Server {
    /*
    public static void main(String[] args){
        //服务类
        ServerBootstrap bootstrap = new ServerBootstrap();

        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        //设置nioSocket工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss,worker));
        //设置管道的工厂
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("helloHandler",new HelloHandler());
                return pipeline;
            }
        });
        //绑定端口号
        bootstrap.bind(new InetSocketAddress(10101));
        System.out.println("start");
    }
    */
}
