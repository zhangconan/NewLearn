package com.zkn.newlearn.gof.decorate;

/**
 * Created by zkn on 2016/11/14.
 * 测试装饰模式
 */
public class DecoratePatternTest01 implements DecorateInterface{

    private DecorateInterface decorateInterface;

    public DecoratePatternTest01(DecorateInterface decorateInterface) {
        this.decorateInterface = decorateInterface;
    }

    @Override
    public void read(){
        decorateInterface.read();
    }

    public static void main(String[] args){
        DecoratePatternTest01 decoratePatternTest01 = new DecoratePatternTest01(new DecorateTest02(new DecorateTest01()));
        decoratePatternTest01.read();
    }
}

/**
 * 装饰模式的接口
 */
interface DecorateInterface {

    void read();
}
/**
 * 装饰接口的第一个实现类
 */
class DecorateTest01 implements DecorateInterface {

    private DecorateInterface decorateInterface;

    @Override
    public void read() {

        System.out.println("我是第一个实现类");
    }

    public DecorateTest01(DecorateInterface decorateInterface) {
        this.decorateInterface = decorateInterface;
    }

    public DecorateTest01() {
    }
}

/**
 * 装饰接口的第二个实现类
 */
class DecorateTest02 implements DecorateInterface {

    private DecorateInterface decorateInterface;

    @Override
    public void read() {
        decorateInterface.read();
        System.out.println("我是第二个实现类");
    }

    public DecorateTest02(DecorateInterface decorateInterface) {
        this.decorateInterface = decorateInterface;
    }
}

