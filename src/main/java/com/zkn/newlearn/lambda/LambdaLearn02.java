package com.zkn.newlearn.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wb-zhangkenan on 2016/12/8.
 */
public class LambdaLearn02 {

    @Test
    public void testLoopCollection(){

        final List<String> list =
                Arrays.asList(new String[]{"wqqwqw","wwewe","wwewesw2w","5w2ewew"});
        //声明式的代码
        //使用内部迭代器  forEach
        System.out.println("测试使用内部迭代器forEach");
        list.forEach(System.out::println);
        //只有一个参数的时候可以省略()
        System.out.println("测试使用内部迭代器省略()");
        list.forEach(name -> System.out.println(name));
        //使用流的方式
        System.out.println("测试使用集合的Stream");
        list.stream().forEach(System.out::println);
        //将小写字母转换为大写字母
        //stream()是集合所有的方法，该方法的返回值是一个Stream类型的实例。
        //map函数适合于根据函数转换元素
        System.out.println("测试map函数");
        list.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
        //map()函数里使用方法引用
        System.out.println("测试map函数中的方法引用");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        //过滤不符合条件的方法
        System.out.println("测试filter方法");
        list.stream().filter(name -> name.startsWith("w")).collect(Collectors.toList()).forEach(System.out::print);
        Map<String,String> map = new HashMap<String,String>(){
            {
                put("zhangsan","张三");
                put("lisi","李四");
                put("wangwu","王五");
                put("maliu","马六");
            }
        };
        //当有多个参数的时候，需要加上()
        System.out.println("\r\n"+"测试集合的内部迭代器");
        map.forEach((key,value)->System.out.println(key+" " + value));
    }

    /**
     * 缩小Lambda表达式的作用域
     */
    @Test
    public void testReduceScope(){

        List<String> list = new ArrayList<String>(){
            {
                add("aaaqwewewew");
                add("aaaqwewewew02");
                add("aaaqwewewew041");
                add("sdwssewwe777");
                add("sdwssewwesd");
                add("wwwdwssewwesd");
                add("wwwwssewwesd");
            }
        };
        //定义一个Lambda表达式
        Function<String,Predicate<String>> function = letter-> name -> name.startsWith(letter);
        //输出以aa开头的集合中的变量
        list.stream().filter(function.apply("aa")).forEach(System.out::println);
        //输出以s开头的集合中的前1(limit函数)个 没有找到的话，不做任何输出
        list.stream().filter(function.apply("sqqq")).limit(1).forEach(System.out::println);
        //格式化字符串，%+S(需要格式化的类型，这个类型可以在Formatter这个类中找到 java.util.Formatter.Conversion)
        System.out.println(String.format("name startWiths %S","zhang"));
        testOptional(list,"a");
    }

    /**
     * 测试 Optional
     * @param list
     * @param letter
     */
    public void testOptional(List<String> list,String letter){

        final Optional<String> optional =
                list.stream().filter(name -> name.startsWith(letter)).findFirst();
        System.out.println(String.format("name startWith %s",letter)+optional.orElse(" name not found"));
    }

    /**
     * 测试集合规约
     */
    @Test
    public void testCollection(){
        //构造一个IntStream对象
        IntStream intStream = IntStream.of(1,4,12,34,112,533);
        //对intStream中的元素求和  sum函数是一个终结操作
        System.out.println("对intStream中的元素求和"+intStream.sum());
        //对intStream中的元素求平均值 average也是一个终结操作
        intStream = IntStream.of(1,4,12,34,112,533);
        System.out.println("对intStream中的元素求平均值"+intStream.average());
        intStream = IntStream.of(1,4,12,34,112,533);
        //对intStream中的元素进行排序操作
        intStream.sorted().forEach(System.out::println);
        //取出特定的元素值
        List<String> list = getStringList();
        Optional<String> optional =
                list.stream().reduce((name1,name2) -> name1.length() - name2.length() > 0 ? name1 : name2);
        //如果Optional中的值为null的话，get方法会报异常
        System.out.println(optional.get());
    }
    @Test
    public void testCollection01(){

        System.out.println(IntStream.of(1,4,12,34,112,533)
                .filter(e-> e > 20)
                .reduce(0,Integer::sum));
        IntStream.of(1,4,12,34,112,533)
                .filter(e-> e > 20)
                .average()
                .ifPresent(e -> System.out.println(e));
        IntStream.of(1,4,12,34,112,533)
                .filter(e-> e > 20)
                .max()
                .ifPresent(e -> System.out.println(e));
    }
    /**
     * 测试连接元素
     */
    @Test
    public void testJoiner(){

        //StringJoiner中的join方法来连接元素
        List<String> list = getStringList();
        System.out.println(String.join(",",list));
        //使用Stream中的collect函数
        System.out.println(list.stream().collect(Collectors.joining(",")));
    }

    public List<String> getStringList(){
        //取出特定的元素值
        List<String> list = new ArrayList<String>(){
            {
                add("zhangsdan");
                add("zhangsdanwangwu");
                add("zhangsdanlisi");
            }
        };
        return list;
    }
}
