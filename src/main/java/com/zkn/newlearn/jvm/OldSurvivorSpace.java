package com.zkn.newlearn.jvm;

/**
 * Created by zkn on 2017/1/29.
 * 在旧生代上分配对象
 */
public class OldSurvivorSpace {
    public static void main(String[] args){

        MemoryObject memoryObject = new MemoryObject(1024*1024);//1M的对象
        MemoryObject memoryObject2 = new MemoryObject(1024*1024*2);//2M的对象
        try {
            Thread.sleep(4000);
            MinorGCDemo.happenMinorGC(9);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
