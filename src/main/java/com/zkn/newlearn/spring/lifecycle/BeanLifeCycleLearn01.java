package com.zkn.newlearn.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by zkn on 2017/4/24.
 */
public class BeanLifeCycleLearn01 implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
    /**
     * 姓名
     */
    private String name;
    /**
     * BeanFactory
     */
    private BeanFactory beanFactory;

    private String beanName;

    public BeanLifeCycleLearn01() {
        System.out.println("---------调用BeanLifeCycleLearn01的构造器实例化---------");
    }

    /**
     * 这是BeanFactoryAware接口方法
     * @see BeanFactoryAware
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    /**
     * 这是BeanNameAware接口方法
     * @see BeanNameAware
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
    }

    /**
     * 这是DisposableBean接口方法
     * @see DisposableBean
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }
    /**
     * 这是InitializingBean接口方法
     * @see  InitializingBean
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }
}
