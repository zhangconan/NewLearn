package com.zkn.newlearn.jdk8.lambda;

import java.util.function.Consumer;

/**
 * Created by zkn on 2017/7/24.
 */
@FunctionalInterface
public interface ConsumerAccept<T> extends Consumer<T> {

    @Override
    default void accept(T t) {
        testAccept(t);
        System.out.println("我是default");
    }

    void testAccept(T t);
}
