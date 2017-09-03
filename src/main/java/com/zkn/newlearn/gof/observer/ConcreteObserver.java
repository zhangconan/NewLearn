package com.zkn.newlearn.gof.observer;

/**
 * Created by zkn on 2017/9/3.
 */
public class ConcreteObserver implements Observer {
    /**
     * 更新主题
     */
    @Override
    public void update() {
        System.out.println("我是第一个观察者......");
    }
}
