package com.zkn.newlearn.jvm.geek_time.classloader;

/**
 * @author zkn
 * @date 2018/8/8 0:20
 **/
public class ClassLoaderSecond {

    public static void main(String[] args) {
        SecondInner.method();
    }
}

class SecondInner {

    static {
        System.out.println("我是静态方法!");
    }

    public static void method() {
        System.out.println("我被调用了!");
    }
}