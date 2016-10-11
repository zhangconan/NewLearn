package com.zkn.newlearn.tester;

/**
 * Created by wb-zhangkenan on 2016/10/11.
 * 子类在实例化的时候会默认调用父类的构造函数，
 * 因为在jvm加载类的时候，存在被动初始化父类的动作。
 */
public class TestSimpleConstructor {

    public static void main(String[] args){

        FatherSimpleConstructor fatherSimpleConstructor = new SubSimpleConstructor(1000);
    }
}

abstract class FatherSimpleConstructor{
    public static final int DEFAULT_PORT = 4000;
    public FatherSimpleConstructor(int test){
        int port = getPort();
        /**
         * 在初始化父类的时候，子类还没被初始化，所示
          */
        System.out.println("端口号是："+port);
    }
    public FatherSimpleConstructor(){

    }
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
