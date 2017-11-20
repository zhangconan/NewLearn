package com.zkn.newlearn.thread.future;

import org.junit.Test;

/**
 * Created by wb-zhangkenan on 2017/5/5.
 *  主要还是运用适配器的设计模式
 * @author wb-zhangkenan
 * @date 2017/05/05
 */
public class FutureTest {

    @Test
    public void testFuture(){

        NewFutureTask<Integer> newFuture = new NewFutureTask<>(()->{
            int i=0;
            for(;i<10;i++){
                i++;
            }
            return i;
        });
        new Thread(newFuture).start();
        System.out.println(newFuture.get());
        System.out.println("我完成了....");
    }
}
