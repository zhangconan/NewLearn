package com.zkn.newlearn.jvm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;

/**
 * Created by zkn on 2017/6/3.
 * 测试CPU乱序
 */
public class CPUDisordeTest {

    int a = 0, b = 0, x = 0, y = 0;

    public static void test(int i){

        CPUDisordeTest test = new CPUDisordeTest();
        Thread threadA = new Thread(()->{
            test.a = 1;
            test.x = test.b;
        });
        Thread threadB = new Thread(()->{
            test.b = 1;
            test.y = test.a;
        });
        threadA.start();
        threadB.start();
        //确保线程执行完
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("case%s x:%s y:%s",i,test.x,test.y));
    }

    public static void main(String[] args) {
        try {
            PrintStream pw = new PrintStream(new FileOutputStream("G:\\LearnVideo\\testout.txt"));
            System.setOut(pw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //循环一百次
        IntStream.range(0,1000000).forEach(CPUDisordeTest::test);
    }
}
