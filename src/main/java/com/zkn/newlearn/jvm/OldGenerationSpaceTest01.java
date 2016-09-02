package com.zkn.newlearn.jvm;

/**
 * Created by wb-zhangkenan on 2016/8/31.
 */
public class OldGenerationSpaceTest01 {
    public static void main(String[] args) throws InterruptedException {
        byte[] bytes = new byte[1024*1024*2];
        byte[] bytes1 = new byte[1024*1024*2];
        byte[] bytes2 = new byte[1024*1024*2];
        System.out.println("准备再旧生代上分配空间");
        Thread.sleep(20000);
        byte[] bytes3 = new byte[1024*1024*4];
        Thread.sleep(30000);
    }
}
