package com.zkn.newlearn.gof.observer;

/**
 * Created by zkn on 2017/9/3.
 */
public interface Subject {
    /**
     * 添加观察者
     */
    void addObserver(Observer observer);

    /**
     * 删除观察者
     */
    void deleteObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObserver();
}
