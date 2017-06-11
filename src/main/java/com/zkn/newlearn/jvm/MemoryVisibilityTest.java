package com.zkn.newlearn.jvm;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by zkn on 2017/6/4.
 */
public class MemoryVisibilityTest {
    int a = 0;

    public void add(){
        a++;
    }
    @Test
    public void testMulti() {
        IntStream.range(0, 100).forEach(i -> {
            MemoryVisibilityTest visibility = new MemoryVisibilityTest();
            Thread thread01 = new Thread(() -> {
                System.out.println("Thread01 a:" + visibility.a);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //visibility.a++;
                visibility.add();
            });
            Thread thread02 = new Thread(() -> {
                System.out.println("Thread02 before a:" + visibility.a);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread02 after a:" + visibility.a);
            });
            thread01.start();
            thread02.start();
            try {
                thread01.join();
                thread02.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testSame() {
        Visibility visibility = new Visibility();
        visibility.start();
        try {
            //让线程执行一段时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //停止线程
        visibility.stopFlag();
        System.out.println(visibility.getFlag());
        try {
            //陷入死循环
            visibility.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Visibility extends Thread {
        private boolean flag = false;

        @Override
        public void run() {
            int i = 0;
            while (!flag) {
                i++;
            }
            System.out.println("finish loop i:" + i);
        }

        public void stopFlag() {
            flag = true;
        }

        public boolean getFlag() {
            return flag;
        }
    }
}
