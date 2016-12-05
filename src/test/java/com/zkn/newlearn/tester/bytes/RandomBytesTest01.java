package com.zkn.newlearn.tester.bytes;

import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by wb-zhangkenan on 2016/12/5.
 */
public class RandomBytesTest01 {

    /**
     * 测试Random生产bytes随机数组
     */
    @Test
    public void testRandomBytes(){

        Random random = new Random();
        //要生成随机byte数的数组
        byte[] bytes = new byte[5];
        //将上面的数组填满随机值
        random.nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
    }
}
