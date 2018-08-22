package com.zkn.newlearn.opensource.redis.data.structure;

import com.zkn.newlearn.opensource.redis.data.BaseJedis;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Redis List数据结构
 *
 * @author zkn
 * @date 2018/8/21 23:42
 **/
public class ListStructure extends BaseJedis {

    /**
     * 先进先出队列。右进左出队列。
     */
    @Test
    public void fifoList() {
        //往列表books中插入元素
        //redis-cli命令为：rpush books java pytho
        Long num = getJedis().rpush("books", "java", "python");
        //返回的num是插入之后list中元素的总数
        System.out.println(num);
        num = getJedis().rpush("books", "c#", "c");
        System.out.println(num);
        //获取列表中元素的个数
        //redis-cli命令：llen books
        System.out.println(getJedis().llen("books"));
        for (int i = 0; i < num; i++) {
            //先进先出
            //redis-cli命令：lpop books
            System.out.println(getJedis().lpop("books"));
        }
    }

    /**
     * 先进后出  栈   右进右出
     */
    @Test
    public void filoList() {
        Long num = getJedis().rpush("books", "java", "go", "python");
        for (int i = 0; i < num; i++) {
            System.out.println(getJedis().rpop("books"));
        }
        num = getJedis().lpush("books", "java", "go", "python");
        for (int i = 0; i < num; i++) {
            System.out.println(getJedis().lpop("books"));
        }
    }

    @Test
    public void slowOperation() {
        Long num = getJedis().rpush("books", "java", "go", "python");
        //使用 lindex 命令
        System.out.println(getJedis().lindex("books", 2));
        //使用lrange命令  start_index end_index可以为负数
        List<String> listEle = getJedis().lrange("books", 0, -1);
        System.out.println(Arrays.toString(listEle.toArray(new String[0])));
        //ltrim命令
        // ltrim 和字面上的含义不太一样，个人觉得它叫 lretain(保留) 更合适一些，因为 ltrim 跟的两个参数start_index和end_index定义了一个区间，
        // 在这个区间内的值，ltrim 要保留，区间之外统统砍掉。我们可以通过ltrim来实现一个定长的链表，这一点非常有用。
        //index 可以为负数，index=-1表示倒数第一个元素，同样index=-2表示倒数第二个元素...
        System.out.println(getJedis().ltrim("books", 0, -1));
    }
}
