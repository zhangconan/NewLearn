package com.zkn.newlearn.gof.observer;

import java.util.Vector;

/**
 * Created by zkn on 2017/9/3.
 */
public class ConcreteSubject implements Subject {

    private Vector<Observer> vector = new Vector<>();

    /**
     * 添加观察者
     */
    @Override
    public void addObserver(Observer observer) {
        vector.add(observer);
    }

    /**
     * 删除观察者
     */
    @Override
    public void deleteObserver(Observer observer) {
        vector.remove(observer);
    }

    /**
     * 通知观察者
     */
    @Override
    public void notifyObserver() {
        vector.forEach(Observer::update);
    }
}
