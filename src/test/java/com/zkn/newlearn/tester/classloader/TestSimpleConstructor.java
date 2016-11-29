package com.zkn.newlearn.tester.classloader;

/**
 * Created by wb-zhangkenan on 2016/10/11.
 * 子类在实例化的时候会被动的初始化父类（不会实例化父类），默认调用父类的构造函数.
 * 然后才会初始化子类，调用子类的构造函数，初始化完毕后，为成员变量赋值。生成子类的实例。
 */
public class TestSimpleConstructor {

    public static void main(String[] args){

        FatherSimpleConstructor fatherSimpleConstructor = new SubSimpleConstructor(1000);
    }
}

abstract class FatherSimpleConstructor{
    public static final int DEFAULT_PORT = 4000;
    public FatherSimpleConstructor(){
        int port = getPort();
        System.out.println("端口号是："+port);
    }
    /**
    public FatherSimpleConstructor(){

    }
     */
    public abstract int getPort();
}

class SubSimpleConstructor extends FatherSimpleConstructor{
    private int port = 100;

    public SubSimpleConstructor(int _port){
        port = _port;
        System.out.println("子类的端口号是："+port);
    }
    @Override
    public int getPort() {

        return Math.random() > 0.5?port:DEFAULT_PORT;
    }
}
