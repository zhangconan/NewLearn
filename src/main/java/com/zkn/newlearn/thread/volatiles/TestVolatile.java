package com.zkn.newlearn.thread.volatiles;

import java.util.stream.IntStream;

/**
 * Created by wb-zhangkenan on 2017/3/24.
 *  测试volatile刷新内存的时机
 *
 *  测试volatile的读写的内存语义：
 *      在本例子中开启了两个线程，一个线程用来修改普通变量和volatile变量，一个线程用来读取对象的普通和volatile变量.
 *      volatile写的内存语义：
 *          当写一个volatile变量的时候，JMM会把该线程对应的本地内存中的在写volatile变量之前的内容都刷新到主存中。
 *      volatile读的内存语义：
 *          当读一个volatile变量的时候，JMM会把该线程的本地内存失效然后再从主存中读取变量值。
 * @date 2017/03/24
 */
public class TestVolatile {

    private int a;

    private volatile boolean flag = false;

    public void write(){
        a = 12;
        flag =true;
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a = 15;
    }

    public int read(){
        if(flag){
            return a*a;
        }
        return 0;
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args){
        IntStream.range(0,1000).forEach(i->{
            TestVolatile testVolatile = new TestVolatile();
            Thread t1 = new Thread(()->{
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //确保线程1先执行
                testVolatile.write();
            });
            t1.start();

            Thread t2 = new Thread(()->{
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int a = testVolatile.read();
                if(a != 144){
                    System.out.println("循环到第"+i+"次");
                    System.out.println("修改后的值为："+a);
                    System.exit(0);
                }
                System.out.println(testVolatile.read());
            });
            t2.start();
        });
        System.out.println("正常执行结束!");
    }
}

