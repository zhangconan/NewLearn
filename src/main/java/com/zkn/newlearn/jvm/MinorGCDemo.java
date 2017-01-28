package com.zkn.newlearn.jvm;

/**
 * Created by zkn on 2017/1/28.
 * -Xms40M -Xmx40M -Xmn16M -verbose:gc -XX:+PrintGCDetails
 * -Xms 堆最小值
 * -Xmx 堆最大值
 * -Xmn 新生代的值
 * -XX:+PrintGCDetails 打印GC信息
 */
public class MinorGCDemo {
    public static void main(String[] args){

        MemoryObject object = new MemoryObject(1024*1024);
        for(int i=0;i<2;i++){
            happenMinorGC(11);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void happenMinorGC(int happenMinorGCIndex) {

        for(int i=0;i<happenMinorGCIndex;i++){
            if(i == happenMinorGCIndex-1){
                try {
                    Thread.sleep(2000);
                    System.out.println("minor gc should happen");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            new MemoryObject(1024*1024);
        }
    }
}
class MemoryObject {

    private byte[] bytes;

    public MemoryObject(int objectSize) {
        this.bytes = new byte[objectSize];
    }
}
