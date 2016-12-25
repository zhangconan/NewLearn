package com.zkn.newlearn.lambda;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by 北京-张烨 on 2016/12/23 0023.
 */
public class S<T> {
    private Iterator<T> it;

    public S(Iterator it) {
        this.it = it;
    }

    public <R> S<R> map(Function<T, R> f) {
        Iterator<R> mapIt = new Iterator<R>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public R next() {
                if (it.hasNext()) {
                    return f.apply(it.next());
                } else {
                    return null;
                }
            }

            @Override
            public void remove() {

            }
        };
        return new S<R>(mapIt);
    }

    public S<T> filter(Predicate<T> p) {
        Iterator<T> filterIt = new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public T next() {
                if (it.hasNext()) {
                    T t = it.next();
                    if (p.test(t)) {
                        return t;
                    } else {
                        return next();
                    }
                } else {
                    return null;
                }
            }
        };
        return new S(filterIt);
    }

    public void forEach(Consumer<T> consumer) {
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public S<T> limit(int num) {
        Iterator<T> limitIt = new Iterator<T>() {
            private int _limit = 0;

            @Override
            public boolean hasNext() {
                return it.hasNext() && _limit < num;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    _limit++;
                    return it.next();
                } else {
                    return null;
                }
            }
        };
        return new S(limitIt);
    }

    public static void main(String[] args) {
        Iterator<Integer> it = new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return i++;
            }
        };
        S<Integer> s = new S<>(it);
        s.filter(x -> x % 2 == 0)
                .map(x -> x * 3)
                .limit(10)
                .forEach(System.out::println);
    }
}

