package com.zkn.newlearn.opensource.redis.data.structure;

import com.zkn.newlearn.opensource.redis.data.BaseJedis;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

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
    }
}
