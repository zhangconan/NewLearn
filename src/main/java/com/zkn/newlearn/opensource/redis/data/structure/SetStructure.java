package com.zkn.newlearn.opensource.redis.data.structure;

import com.zkn.newlearn.opensource.redis.data.BaseJedis;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * @author zkn
 * @date 2018/8/22 23:58
 **/
public class SetStructure extends BaseJedis {

    @Test
    public void baseOperations() {
        //向集合sets中添加元素
        //redis-cli命令：sadd sets python java
        Long counts = getJedis().sadd("sets", "python", "python");
        System.out.println(counts);
        counts = getJedis().sadd("sets", "java", "go");
        //这个数值是添加成功的元素的个数
        System.out.println(counts);

        //如果集合不存在的话 返回的是一个空集合
        //获取set中所有的元素
        //redis-cli命令：smembers sets
        Set<String> stringSet = getJedis().smembers("sets");
        stringSet.stream().forEach(System.out::println);

        //判断sets集合中是否存在javas这个key 集合不存在的话也返回false
        //redis-cli命令：sismember sets javas
        Boolean exists = getJedis().sismember("sets", "javas");
        System.out.println(exists);

        //获取集合中元素的个数
        //redis-cli命令：scard sets
        Long length = getJedis().scard("sets");
        System.out.println(length);

        //弹出集合中的任意一个元素
        //redis-cli命令 spop sets
        String popString = getJedis().spop("sets");
        System.out.println(popString);
    }
}
