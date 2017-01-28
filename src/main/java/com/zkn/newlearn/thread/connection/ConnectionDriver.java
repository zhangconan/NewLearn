package com.zkn.newlearn.thread.connection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * Created by wb-zhangkenan on 2017/1/23.
 */
public class ConnectionDriver {

    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if("commit".equals(method.getName())){
                TimeUnit.SECONDS.sleep(10);
            }
            return null;
        }
    }

    public static final Connection createConnection(){

        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader()
                ,new Class[]{Connection.class},new ConnectionHandler());
    }
}
