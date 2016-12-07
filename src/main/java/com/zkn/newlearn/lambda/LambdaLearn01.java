package com.zkn.newlearn.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zkn on 2016/12/8.
 * Lambda表达式
 */
public class LambdaLearn01 {

    public static void main(String[] args){
        //Arrays.asList生成的集合不能再被修改
        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12"));
        BigDecimal bigDecimal = prices.stream().//为集合创建一个连续性的Stream
                filter(price -> price.compareTo(new BigDecimal(20)) > 0).//过滤不符合条件的数据
                map(price -> price.multiply(new BigDecimal("0.9"))).//处理之后的结果集
                reduce(BigDecimal.ZERO,BigDecimal::add);//根据给定的函数 对结果进行操作

        System.out.println(bigDecimal.toString());
    }
}
