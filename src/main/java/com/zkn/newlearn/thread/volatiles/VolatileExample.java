package com.zkn.newlearn.thread.volatiles;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;

/**
 * Created by zkn on 2017/6/10.
 */
public class VolatileExample {

    @Test
    public void test() {
        try {
            PrintStream pw = new PrintStream(new FileOutputStream("G:\\LearnVideo\\testout.txt"));
            System.setOut(pw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        IntStream.range(0, 1000000).forEach((i) -> {
            TestReadAndWrite testReadAndWrite = new TestReadAndWrite();
            Thread thread1 = new Thread(() -> {
                testReadAndWrite.writer();
            });
            Thread thread2 = new Thread(() -> {
                testReadAndWrite.reader();
            });
            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

class TestReadAndWrite {
    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            System.out.println("a:" + a);
        }
    }
}
