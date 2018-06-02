package com.zkn.newlearn.io.aio.first;

/**
 * @author zkn
 * @date 2018/5/3
 */
public class TimeServer {

    public static void main(String[] args) {
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(8080);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
