package com.zkn.newlearn.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wb-zhangkenan on 2017/4/27.
 *
 * @author wb-zhangkenan
 * @date 2017/04/27
 */
public class ListLoopRemove {

    public static void main(String[] args) {
        testListIterator();
        testReverseCirculation();
        //可能会发生数组越界
        //testLoop();
        //增强for循环会出现java.util.ConcurrentModificationException异常
        //testForEach();
    }

    private static void testReverseCirculation() {
        List<String> iteratorList = new ArrayList<String>() {{
            add("1zqqqw");
            add("4zqq2qqw");
            add("8zqq332qw");
            add("0zqqqw2");
            add("2zqq1qw");
            add("zszq34qqw");
            add("mmzq99qqw");
        }};
        for (int i = iteratorList.size() - 1; i >= 0; i--) {
            if (iteratorList.get(i).equals("1zqqqw")) {
                iteratorList.remove(i);
            }
        }
        System.out.println(Arrays.toString(iteratorList.toArray(new String[0])));
    }

    public static void testListIterator() {
        List<String> iteratorList = new ArrayList<String>() {{
            add("zqqqw");
            add("zqq2qqw");
            add("zqq332qw");
            add("zqqqw2");
            add("zqq1qw");
            add("zq34qqw");
            add("zq99qqw");
        }};
        ListIterator<String> iterator = iteratorList.listIterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("zqqqw2")) {
                iterator.remove();
            }
        }
        System.out.println(Arrays.toString(iteratorList.toArray(new String[0])));
    }

    private static void testLoop() {
        List<String> iteratorList = new ArrayList<String>() {{
            add("1zqqqw2");
            add("4zqq2qqw4");
            add("8zqq332qw2");
            add("0zqqqw28");
            add("2zqq1qw0");
            add("zszq34qqw3");
            add("mmzq99qqw4");
        }};

        for (int i = 0; i <= iteratorList.size(); i++) {
            if (iteratorList.get(i).equals("mmzq99qqw4")) {
                iteratorList.remove(i);
            }
        }
        System.out.println(Arrays.toString(iteratorList.toArray(new String[0])));
    }

    private static void testForEach(){
        List<String> iteratorList = new ArrayList<String>() {{
            add("1zqqqw2");
            add("4zqq2qqw4");
            add("8zqq332qw2");
            add("0zqqqw28");
            add("2zqq1qw0");
            add("zszq34qqw3");
            add("mmzq99qqw4");
        }};

        for (String str : iteratorList) {
            if (str.equals("mmzq99qqw4")) {
                iteratorList.remove(str);
            }
        }
        System.out.println(Arrays.toString(iteratorList.toArray(new String[0])));
    }
}
