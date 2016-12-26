package com.zkn.newlearn.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wb-zhangkenan on 2016/12/26.
 */
public class StreamLearn01 {

    private static List<String> stream = new ArrayList<String>() {
        {
            add("zhangsan");
            add("zhangsanlisi");
            add("zhangsanwangwu");
            add("zhangsanliuliu");
            add("zhangsanqiba");
        }
    };

    public static void main(String[] args) {

    }

    /**
     * map处理一对一的映射关系
     */
    @Test
    public void testStreamMap() {

        /**
         * Function<T,R> 输入T返回R
         * Consumer<T>  接收T不返回值
         */
        //串行操作
        stream.stream().map(String::toUpperCase).forEach(System.out::println);
        //只是处理原数据，不会改变原数据
        System.out.println(Arrays.toString(stream.toArray()));
        //并行操作，并行操作最后需要合并结果集，要不然结果和自己想象的不太一样下面这个例子可以证明
        stream.stream().parallel().map(String::toUpperCase).forEach(System.out::println);
        //并行操作，最后合并结果集，保证最后的顺序
        stream.stream().parallel().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * flatMap是用来处理一对多映射的
     */
    @Test
    public void testStreamFlatMap() {

        List<List<String>> streamFlatMap = new ArrayList() {
            {
                add(Arrays.asList("zhangsan01", "lisi01"));
                add(Arrays.asList("zhangsan02", "lisi02", "wangwu02"));
                add(Arrays.asList("zhangsan03", "lisi03", "wangwu03", "lilwojsdkjkwe03"));
                add(Arrays.asList("zhangsan04", "lisi04", "wangwu04", "lilwojsdkjkwe04"));
            }
        };
        //flagMap把streamFlatMap中的结构扁平化，将最底层的元素抽出来，放到一起。
        streamFlatMap.stream().flatMap(childRen -> childRen.stream()).map(String::toUpperCase).forEach(System.out::println);
    }

    /**
     * filter
     * filter 对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream。
     * peek
     * peek 对每个元素执行操作并返回一个新的 Stream
     * 只输出符合条件的结果
     * findFirst
     * findFirst 它总是返回Stream的第一个元素，或者空。返回值类型：Optional，可以避免空指针异常
     */
    @Test
    public void testFindFirst() {

        stream.stream().peek(s -> System.out.print(s + "  ")).
                map(String::toUpperCase).
                filter(s -> s.startsWith("ZHANGSAN")).
                findAny().
                ifPresent(s -> System.out.println(s));

        Stream.of("one0", "two0", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * Optional<T> reduce(BinaryOperator<T> accumulator);
     * T reduce(T identity, BinaryOperator<T> accumulator);
     * <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner);
     */
    @Test
    public void testReduce() {

        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
    }

    /**
     * limit/skip
     *  limit返回Stream的前面n个元素；skip则是扔掉前n个元素（它是由一个叫subStream的方法改名而来）。
     * sorted
     *  Stream的排序通过sorted进行
     * min/max/distinct
     *  最小值、最大值、去重
     * allMatch：Stream 中全部元素符合传入的 predicate，返回 true
     * anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
     * noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
     */

}
