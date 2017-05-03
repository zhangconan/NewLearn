package com.zkn.newlearn.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by wb-zhangkenan on 2017/1/25.
 */
public class CompareList {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>() {
            {
                add("张三");
                add("张三0");
                add("张三1");
                add("张三2");
                add("张三3");
                add("张三4");
            }
        };
        List<String> list2 = new LinkedList<String>() {
            {
                add("张三");
                add("张三0");
                add("张三1");
                add("张三2");
                add("张三3");
                add("张三4");
                add("张三41");
            }
        };
        System.out.println(list1.equals(list2));
        System.out.println(listEquals(list1, list2));
    }

    public static <T> boolean listEquals(final List<T> l1, final List<T> l2) {

        Map<T, Long> m1 = l1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<T, Long> m2 = l2.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        boolean b1 = m1.entrySet()
                .stream()
                .allMatch(e -> {
                    Long v1 = m2.get(e.getKey());
                    if (v1 == null) {
                        return false;
                    } else {
                        return v1.equals(e.getValue());
                    }
                });

        boolean b2 = m2.entrySet()
                .stream()
                .allMatch(e -> {
                    Long v1 = m1.get(e.getKey());
                    if (v1 == null) {
                        return false;
                    } else {
                        return v1.equals(e.getValue());
                    }
                });
        return b1 == b2;
    }

    public static void test(){

        List<String> list1 = new ArrayList<String>() {
            {
                add("张三");
                add("张三0");
                add("张三1");
                add("张三2");
                add("张三3");
                add("张三4");
            }
        };
        List<String> list2 = new LinkedList<String>() {
            {
                add("张三");
                add("张三0");
                add("张三1");
                add("张三2");
                add("张三3");
                add("张三4");
                add("张三41");
            }
        };
        System.out.println(list1.equals(list2));
        System.out.println(listEquals(list1, list2));
    }
}
