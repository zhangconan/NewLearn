package com.zkn.newlearn.opensource.redis.data.structure;

import com.zkn.newlearn.opensource.redis.data.BaseJedis;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;

/**
 * redis字符串数据结构
 *
 * @author zkn
 * @date 2018/8/20 23:38
 **/
public class StringStructure extends BaseJedis {

    @Test
    public void baseOperations() {
        //设置字符串的值
        getJedis().set("strName", "strValue");
        //获取字符串的值
        System.out.println(getJedis().get("strName"));
        //删除key的值
        getJedis().del("strName");
        //再次获取字符串的值
        System.out.println(getJedis().get("strName") == null);
    }

    @Test
    public void batchOperations() {
        //通过批量对字符串的读写，减少网络开销。
        getJedis().set("strName1", "strValue1");
        getJedis().set("strName2", "strValue2");
        //批量读字符串的值
        //对应redis-cli命令为： mget strName1 strName2
        List<String> listValue = getJedis().mget("strName1", "strName2");
        System.out.println(Arrays.toString(listValue.toArray(new String[0])));
        //如果有不存在的key，则获取到的值为null
        listValue = getJedis().mget("strName1", "strName3");
        System.out.println(Arrays.toString(listValue.toArray(new String[0])));
        //批量删除key
        //redis-cli命令为 del strName1 strName2
        getJedis().del("strName1", "strName2");
        System.out.println(getJedis().exists("strName1"));

        //批量设置key
        //参数必须为偶数
        //redis-cli命令为： mset strName1 strValue1 strName2 strValue2
        getJedis().mset("strName1", "strValue1", "strName2", "strValue2");
    }

    @Test
    public void setAndExpire() {
        //设置key值
        getJedis().set("strName1", "strValue1");
        System.out.println(getJedis().get("strName1"));
        //设置key过期
        //redis-cli命令为：expire strName1 3
        getJedis().expire("strName1", 3);
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getJedis().get("strName1"));
        //设置key的时候直接设置过期时间
        //redis-cli命令为： setex strName1 2 strExpireValue1
        getJedis().setex("strName1", 2, "strExpireValue1");
        System.out.println(getJedis().get("strName1"));
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getJedis().get("strName1"));
        //如果不存在就创建
        //redis-cli命令为：setnex strName1 strValue2
        getJedis().setnx("strName1", "strValue1");
        System.out.println(getJedis().get("strName1"));
        getJedis().setnx("strName1", "strSetenValue1");
        //因为这个key已经存在了 所以创建不成功
        System.out.println(getJedis().get("strName1"));
    }

    /**
     * 如果value值是一个整数，则可以对它进行自增长。自增长是有范围的，它的范围是singed long的最大最小值。
     * 超过了这个值会报错。
     */
    @Test
    public void increase() {
        getJedis().set("age", "12");
        //年龄增加1
        //redis-cli命令为：incr age
        getJedis().incr("age");
        System.out.println(getJedis().get("age"));
        //年龄增加5
        //redis-cli命令为： incrby age 5
        getJedis().incrBy("age", 5);
        System.out.println(getJedis().get("age"));
    }
    /**
     *字符串是由多个字节组成，每个字节又是由8个bit组成，如此便可以将一个字符串看成很多bit的组合。这便是bitmap数据结构。
     */
}
