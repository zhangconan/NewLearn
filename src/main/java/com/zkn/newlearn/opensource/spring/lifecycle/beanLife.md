InitializingBean:    
    
    方法：void afterPropertiesSet() throws Exception;  
    执行时机：当设置完所有的属性值之后被调用。被BeanFactory调用. 如果有熟悉没有设置或者设置错误的话可以抛出异常.  
    注意：Bean为单例。
    Tips：Spring不建议实现InitializingBean这种用法，这种用法与代码的耦合度比较高。可以在XML中配置init-method属性指定方法来代替这种写法。
    执行顺序：@PostConstruct元注解->InitializingBean的afterPropertiesSet()->自定义init()方法配置

DisposableBean:
    
    方法：void destroy() throws Exception;  
    执行时机：当Spring容器关闭的时候。被一个BeanFactory调用。  
    注意：Bean为单例。
    Tips：Spring不建议实现DisposableBean这种用法，这种用法与代码的耦合度比较高。可以在XML中配置destroy-method属性指定方法来代替这种写法。
    执行顺序：@PreDestory元注解->DisposableBean的destory()->自定义destory()方法
    
BeanNameAware:

    方法：void setBeanName(String name);
    执行时机：所有的属性设置完成之后，InitializingBean的afterPropertiesSet()方法或者init-method方法调用之前.
    作用：由创建这个Bean的BeanFactory设置在BeanFactory中的名字。
 
BeanFactoryAware：

    方法：void setBeanFactory(BeanFactory beanFactory) throws BeansException;
    执行时机：所有的属性设置完成之后，InitializingBean的afterPropertiesSet()方法或者init-method方法调用之前.
    作用：获取创建这个Bean的BeanFactory。
    Tips：不建议使用。

    
    
    
     