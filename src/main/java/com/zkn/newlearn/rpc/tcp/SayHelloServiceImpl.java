package com.zkn.newlearn.rpc.tcp;

/**
 * Created by zkn on 2017/6/12.
 */
public class SayHelloServiceImpl implements SayHelloService {

    @Override
    public String sayHello(String str) {
        System.out.println("Hello TCP! " + str);
        return str;
    }
}
