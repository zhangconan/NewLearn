package com.zkn.newlearn.rpc.tcp;

/**
 * Created by zkn on 2017/6/12.
 */
public interface SayHelloService {
    /**
     * 远程服务的接口
     *
     * @return
     */
    String sayHello(String str);
}
