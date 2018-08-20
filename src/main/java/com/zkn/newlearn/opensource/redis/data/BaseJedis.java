package com.zkn.newlearn.opensource.redis.data;

import org.junit.Before;
import redis.clients.jedis.Jedis;

/**
 * @author zkn
 * @date 2018/8/20 23:50
 **/
public class BaseJedis {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("127.0.0.1", 6379);
    }

    public Jedis getJedis() {
        return jedis;
    }
}
