package com.zkn.newlearn.jvm.depth_analysis_jvm.third.memory_allocation;

/**
 * 新生代直接在Eden区域分配
 *
 * @author zkn
 * @date 2018/5/13
 */
public class NewObjectEden {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        //jvm param -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -verbose:gc -XX:SurvivorRatio=8 -XX:+UseSerialGC
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
