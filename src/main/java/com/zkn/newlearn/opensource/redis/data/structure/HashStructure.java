package com.zkn.newlearn.opensource.redis.data.structure;

import com.zkn.newlearn.opensource.redis.data.BaseJedis;
import org.junit.Test;

import java.util.Map;

/**
 * Redis hash结构 字典结构
 *
 * @author zkn
 * @date 2018/8/22 23:10
 **/
public class HashStructure extends BaseJedis {

    @Test
    public void baseOperations() {
        //设置 hash值
        //redis-cli命令为：hset book python "basic python"    字符串有空格的话 要用" " 括起来
        getJedis().hset("java", "java", "think in java");
        //获取某个hash所有值
        //redis-cli命令为：hgetall java
        Map<String, String> hashResult = getJedis().hgetAll("java");
        hashResult.forEach((key, value) -> System.out.println("key:" + key + " value:" + value));
        //获取hash长度
        //redis-cli命令为：hlen java
        System.out.println(getJedis().hlen("java"));
        //获取某个hash的某个key值
        //redis-cli命令：hget java java
        System.out.println(getJedis().hget("java", "java"));
    }

    @Test
    public void incrOperations() {
        getJedis().hset("inthash", "key", "1");
        getJedis().hincrBy("inthash", "key", 2);
        System.out.println(getJedis().hget("inthash", "key"));
    }
}
