package com.zkn.newlearn.jvm.classloader;

/**
 * Created by wb-zhangkenan on 2017/4/10.
 * 测试类的初始化。
 *  主要初始化的是类中声明的静态字段。
 * @author wb-zhangkenan
 * @date 2017/04/10
 */
public class MethodCauseInitlation {

    public static void main(String[] args){
        MethodInit.testInit();
    }
}

class MethodInit{

    private static int a = 12;

    static {
        System.out.println("我在方法的上面。。。。");
    }

    public static void testInit(){
        System.out.println("我在方法中。。。。a的值为："+a);
    }

    static {
        a = 15;
        System.out.println("我在方法的后面。。。。");
    }

}
