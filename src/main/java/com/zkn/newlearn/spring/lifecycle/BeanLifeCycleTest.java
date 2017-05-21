package com.zkn.newlearn.spring.lifecycle;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by wb-zhangkenan on 2017/4/24.
 *
 * @date 2017/04/24
 */
public class BeanLifeCycleTest {

    @Test
    public void testBeanFactoryLifeCycle(){
        //1)加载配置文件并启动容器
        DefaultListableBeanFactory df = new DefaultListableBeanFactory();
        new XmlBeanDefinitionReader(df).loadBeanDefinitions(new ClassPathResource("com/zkn/newlearn/spring/lifecycle/beans.xml"));
        //2)向容器中注册BeanPostProcessor后处理器
        df.addBeanPostProcessor(new BeanPostProcessor01());
        //3)向容器中注册InstantiationAwareBeanPostProcessorAdapter后处理器
        df.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor01());
        //4)第一次从容器中获取bean,将触发容器实例化该Bean，这将引发Bean生命周期方法的调用
        BeanLifeCycleLearn01 beanLifeCycle = (BeanLifeCycleLearn01) df.getBean("beanLifeCycleLearn01");
        System.out.println(beanLifeCycle.toString());
        //5)第二次从容器中获取bean，直接从缓存池中获取
        System.out.println("第二次从容器中获取Bean");
        BeanLifeCycleLearn01 beanLifeCycle2 = (BeanLifeCycleLearn01) df.getBean("beanLifeCycleLearn01");
        System.out.println(beanLifeCycle2.toString());
        //6)看看这两次获取的Bean是不是同一个。
        System.out.println("beanLifeCycle == beanLifeCycle2  "+(beanLifeCycle == beanLifeCycle2));
        //7)关闭容器
        df.destroySingletons();
    }

    @Test
    public void testBeanLifeCycle(){

        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("com/zkn/newlearn/spring/lifecycle/beans.xml");

        BeanLifeCycleLearn01 beanLifeCycle = (BeanLifeCycleLearn01)applicationContext.getBean("beanLifeCycleLearn01");
        System.out.println(beanLifeCycle.toString());
        ((ClassPathXmlApplicationContext)applicationContext).registerShutdownHook();
    }
}
