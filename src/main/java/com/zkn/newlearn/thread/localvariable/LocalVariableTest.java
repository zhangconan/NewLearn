package com.zkn.newlearn.thread.localvariable;

/**
 * Created by wb-zhangkenan on 2017/1/13.
 */
public class LocalVariableTest {

    public void run(){
        int a = 0;
        run01(a);
    }

    public void run01(int a){
        for(int i=0;i<10_000_000;i++) {
            a++;
        }
        System.out.println(a);
    }
}
