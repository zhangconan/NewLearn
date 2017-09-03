package com.zkn.newlearn.gof.observer;

/**
 * Created by zkn on 2017/9/3.
 */
public class Client {

    public static void main(String[] args) {
        //主题
        Subject subject = new ConcreteSubject();
        //观察者
        Observer obs1 = new ConcreteObserver();
        Observer obs2 = new ConcreteSecObserver();
        //添加观察者
        subject.addObserver(obs1);
        subject.addObserver(obs2);
        //通知观察者
        subject.notifyObserver();
    }
}
