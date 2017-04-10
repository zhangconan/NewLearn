package com.zkn.newlearn.classloader;

import java.util.Random;

/**
 * Created by wb-zhangkenan on 2017/3/22.
 *
 * @author wb-zhangkenan
 * @date 2017/03/22
 */
public class InitTest02 {

    public static void main(String[] args){
        System.out.println(Test01.a);
    }
}

class Test01{

    //public static final int a = new Random().nextInt(100);
    public static final int a = 2;
    static {
        System.out.println("11111111");
    }

}