package com.zkn.newlearn.script;

import javax.script.*;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 *  共有三个级别的地方可以存取属性，分别是ScriptEngineManager中的Bindings，ScriptEngine实例对应的ScriptContext
 *  中含有的 Bindings，以及调用eval函数时传入的Bingdings。离函数调用越近，其作用域越小，优先级越高，
 *  相当于编程语言中的变量的可见域，即Object getAttribute(String name)中提到的优先级。
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class ScopeTest {

    public static void main(String[] args){

        String script = "print(greeting)";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        //往ScriptEngineManager中的变量赋值
        manager.put("greeting","Hello from ScriptEngineManager");
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        //往ScriptEngine中的变量赋值
        engine.put("greeting","Hello from ScriptEngine");
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        //往ScriptContext中的变量赋值
        ScriptContext scriptContext = new SimpleScriptContext();
        scriptContext.setAttribute("greeting", "Hello from eval method",
                ScriptContext.ENGINE_SCOPE);
        try {
            engine.eval(script,scriptContext);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
