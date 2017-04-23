package com.zkn.newlearn.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by zkn on 2017/4/24.
 */
public class BeanFactoryPostProcessor01 implements BeanFactoryPostProcessor {

    public BeanFactoryPostProcessor01() {
        super();
        System.out.println("这是BeanFactoryPostProcessor实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
            throws BeansException {
        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
        BeanDefinition bd = arg0.getBeanDefinition("beanLifeCycleLearn01");
        bd.getPropertyValues().addPropertyValue("name", "wangwuwu");
    }
}
