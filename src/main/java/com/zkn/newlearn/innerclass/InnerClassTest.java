package com.zkn.newlearn.innerclass;
/**
 * Created by zkn on 2017/11/7.
 */

import org.junit.Test;

/**
 * @author zkn
 * @date 2017/11/7 21:38
 */
public class InnerClassTest {

    @Test
    public void test() {
        InnerClassLearn innerClassLearn = new InnerClassLearn();
        innerClassLearn.setInnerClassInvoker(new InnerClassInvoker());
        innerClassLearn.invokerInnerClass();
    }
}
