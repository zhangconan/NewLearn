package com.zkn.newlearn.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * Created by zkn on 2016/11/14.
 */
public class ReflectDecorateTest01 implements Ability{

    private Ability ability;

    private Class<? extends Feature> clazz;

    @Override
    public void sayYouAbility() {
        /**
         * 动态代理
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = null;
                if(Modifier.isPublic(method.getModifiers())){
                    obj = method.invoke(clazz.newInstance(),args);
                }
                ability.sayYouAbility();
                return obj;
            }
        };

        Feature feature = (Feature) Proxy.newProxyInstance(getClass().getClassLoader(),clazz.getInterfaces(),invocationHandler);
        feature.ability();
    }

    public ReflectDecorateTest01(Ability ability, Class<? extends Feature> clazz) {
        this.ability = ability;
        this.clazz = clazz;
    }

    public ReflectDecorateTest01() {
    }

    public static void main(String[] args){
        Ability ability = new Ability() {
            @Override
            public void sayYouAbility() {
                System.out.println("你有什么能力！");
            }
        };
        ability = new ReflectDecorateTest01(ability,ReadAbility.class);
        ability = new ReflectDecorateTest01(ability,WriteAbility.class);
        ability.sayYouAbility();
    }
}

/**
 * 能力
 */
interface Feature{
    void ability();
}

/**
 * 读书的能力
 */
class ReadAbility implements Feature {

    @Override
    public void ability() {
        System.out.println("我会读书、、、");
    }
}

/**
 * 写字的能力
 */
class WriteAbility implements Feature {

    @Override
    public void ability() {
        System.out.println("我会写字。、、、、");
    }
}
/**
 * 有什么能力
 */
interface Ability {
    void sayYouAbility();
}


