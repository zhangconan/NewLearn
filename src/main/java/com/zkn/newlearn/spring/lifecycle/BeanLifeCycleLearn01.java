package com.zkn.newlearn.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by zkn
 * BeanFactoryAware、BeanNameAware、InitializingBean、DisposableBean是Bean级的生命周期接口方法.
 */
public class BeanLifeCycleLearn01 implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean,ApplicationContextAware {
    /**
     * 姓名
     */
    private String name;
    /**
     * BeanFactory
     */
    private BeanFactory beanFactory;

    private String beanName;

    static {
        System.out.println("BeanLifeCycleLearn01的静态方法块。。。。");
    }

    private ApplicationContext applicationContext;

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
        this.beanName = s;
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

    public void setName(String name) {
        System.out.println("BeanLifeCycleLearn01调用set方法进行name属性值的设置!");
        this.name = name;
    }

    public void initMethod(){
        System.out.println("我是配置文件中的init-method。。。。");
    }

    public void destoryMethod(){
        System.out.println("我是配置文件中的destory-method。。。。");
    }

    @Override
    public String toString() {
        return "BeanLifeCycleLearn01{" +
            "name='" + name + '\'' +
            ", beanName='" + beanName + '\'' +
            '}';
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("ApplicationContextAware中的setApplicationContext方法。。。。。");
    }
}
