package com.zkn.newlearn.jvm.geek_time.classloader;

/**
 * @author zkn
 * @date 2018/8/8 0:05
 **/
public class ClassLoaderFirst {

    private int a = 1;

    private static int b = 2;

    private final static int c = 3;

    private int d;

    private static int e;

    private int f;

    static {
        e = 5;
    }

    {
        f = 6;
    }

    public ClassLoaderFirst() {
        d = 4;
    }
}
