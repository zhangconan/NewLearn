package com.zkn.newlearn.tester.lambda;

import com.zkn.newlearn.jdk8.lambda.InterfaceFiledDomain;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zkn on 2017/7/24.
 */
public class InterfaceFiledDomainTest {

    @Test
    public void testAccept() {

        InterfaceFiledDomain interfaceFiledDomain = new InterfaceFiledDomain();
        interfaceFiledDomain.setConsumerAccept((c) -> {

            System.out.println("testccccccc");
        });
        Map<String, String> testMap = new HashMap<String, String>() {
            {
                put("zhangs","lisi");
                put("zhangs1111","lisi11111");
                put("zhangs22222","lisi22222");
            }
        };
        interfaceFiledDomain.getConsumerAccept().accept(testMap);
    }
}
