package com.zkn.newlearn.opensource.redis.data.structure;

import com.zkn.newlearn.opensource.redis.data.BaseJedis;
import org.junit.Test;

/**
 * @author zkn
 * @date 2018/8/30 23:08
 **/
public class ZsetStructure extends BaseJedis {

    @Test
    public void baseOperations() {
        //向集合zsets中添加元素 第二个参数是权重
        Long counts = getJedis().zadd("zsets", 8.9, "java");
        System.out.println(counts);

        counts = getJedis().zadd("zsets", 7.8, "Python");
        System.out.println(counts);
        //按照权重从小到大排序
        //redis-cli命令：zrange zsets 0 -1
        getJedis().zrange("zsets", 0, -1).stream().forEach(System.out::println);
        //按照权重从大到小排序
        getJedis().zrevrange("zsets", 0, -1).stream().forEach(System.out::println);

        //输出元素的个数
        System.out.println(getJedis().zcard("zsets"));
        //输出元素的权重
        System.out.println(getJedis().zscore("zsets", "java"));
        //输出权重范围内的元素
        getJedis().zrangeByScore("zsets", 7, 10).stream().forEach(System.out::println);
        //输出带权重的元素
        getJedis().zrangeByScoreWithScores("zsets", "-inf", "10").stream().forEach(System.out::println);
        //移除集合的元素
        System.out.println(getJedis().zrem("zsets", "java"));
    }
}
