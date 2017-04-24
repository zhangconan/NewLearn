package com.zkn.newlearn.spring.lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wb-zhangkenan on 2017/4/24.
 *
 * @date 2017/04/24
 */
public class BeanLifeCycleTest {

    @Test
    public void testBeanLifeCycle(){

        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext(
            "com/zkn/newlearn/spring/lifecycle/beans.xml");

        BeanLifeCycleLearn01 beanLifeCycle = (BeanLifeCycleLearn01)applicationContext.getBean("beanLifeCycleLearn01");
        System.out.println(beanLifeCycle.toString());

        ((ClassPathXmlApplicationContext)applicationContext).registerShutdownHook();
    }
}
