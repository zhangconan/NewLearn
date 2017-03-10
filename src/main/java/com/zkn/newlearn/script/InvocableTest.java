package com.zkn.newlearn.script;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 *
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class InvocableTest {

    public static void main(String[] args){
        /**
         * 有时候，用户可能并不需要运行已有的整个脚本程序，
         * 而仅仅需要调用其中的一个过程，或者其中某个对象的方法，
         * 这个时候 Invocable 接口就能发挥作用。它提供了两个函数invokeFunction 和
         * invokeMethod，分别允许Java应用程序直接调用脚本中的一个全局性的过程以及对象中的方法，
         * 调用后者时，除了指定函数名字和参数外，还需要传入要调用的对象引用，
         * 当然这需要脚本引擎的支持。不仅如此，Invocable 接口还允许Java应用程序从这些函数中直接返回一个接口，
         * 通过这个接口实例来调用脚本中的函数或方法，从而我们可以从脚本中动态的生成 Java 应用中需要的接口对象
         */
        String script = " function greeting(message){print (message);}";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        if (engine instanceof Invocable) {
            Invocable invocable = (Invocable) engine;
            try {
                invocable.invokeFunction("greeting", "hi");
                invocable.invokeFunction("nogreeing");
            } catch (ScriptException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
