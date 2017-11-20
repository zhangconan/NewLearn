package com.zkn.newlearn.jdk8.lambda;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
/**
 * Created by 北京-张烨 on 2016/12/23 0023.
 */
public class L {
    public static<T,R> List<R> map(Function<T, R> f, List<T> list) {
        List<R> ret = new LinkedList<>();
        for(T item: list) {
            ret.add(f.apply(item));
        }
        return ret;
    }

    public static<T> List<T> filter(Predicate<T> p, List<T> list) {
        List<T> ret = new LinkedList<>();
        for (T item: list) {
            if (p.test(item)) {
                ret.add(item);
            }
        }
        return ret;
    }

    public static<T, R>  R reduce(BiFunction<R,T,R> f, R init, List<T> list) {
        R ret = init;
        for (T item: list) {
            ret = f.apply(ret, item);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> t = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> r = L.map((x)->x * 2, t);
        List<Integer> o = L.filter((x)-> x % 2== 0, t);
        int p = L.reduce((x, y) -> x + y , 0, t);
        //用reduce定义map
        BiFunction<Function<Integer, Integer>, List<Integer>, List<Integer>>  map = new BiFunction<Function<Integer, Integer>, List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(Function<Integer, Integer> integerIntegerFunction, List<Integer> integers) {
                List<Integer> t = new LinkedList<>();
                return reduce((x, y)-> {
                    x.add(integerIntegerFunction.apply(y));
                    return x;
                }, new LinkedList<>(), integers);
            }
        };
        List r0 = map.apply((x)->x * 2, t);
        //reduce map
        System.out.println(Arrays.deepToString(r0.toArray()));
        //map
        System.out.println(Arrays.deepToString(r.toArray()));
        //filter
        System.out.println(Arrays.deepToString(o.toArray()));
        //reduce
        System.out.println(p);
    }
}

