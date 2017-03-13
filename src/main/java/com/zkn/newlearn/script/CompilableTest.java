package com.zkn.newlearn.script;

import javax.script.*;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 *
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class CompilableTest {
    /**
     * 一般来说，脚本语言都是解释型的，这也是脚本语言区别与编译语言的一个特点，
     * 解释性意味着脚本随时可以被运行，开发者可以边开发边查看接口，
     * 从而省去了编译这个环节，提供了开发效率。但是这也是一把双刃剑，当脚本规模变大，
     * 重复解释一段稳定的代码又会带来运行时的开销。有些脚本引擎支持将脚本运行编译成某种中间形式，
     * 这取决与脚本语言的性质以及脚本引擎的实现，可以是一些操作码，甚至是 Java 字节码文件。
     * 实现了这个接口的脚本引擎能把输入的脚本预编译并缓存，从而提高多次运行相同脚本的效率。
     * Java 脚本 API 还为这个中间形式提供了一个专门的类，每次调用 Compilable 接口的编译函数都会返回一个
     * CompiledScript 实例。CompiledScript 类被用来保存编译的结果，
     * 从而能重复调用脚本而没有重复解释的开销，实际效率提高的多少取决于中间形式的彻底程度，
     * 其中间形式越接近低级语言，提高的效率就越高。每一个 CompiledScript 实例对应于一个脚本引擎实例，
     * 一个脚本引擎实例可以含有多个 CompiledScript（这很容易理解），调用 CompiledScript 的 eval
     * 函数会传递给这个关联的 ScriptEngine 的 eval 函数。关于 CompiledScript 类需要注意的是，
     * 它运行时对与之对应的 ScriptEngine 状态的改变可能会传递给下一次调用，造成运行结果的不一致
     * @param args
     * @throws ScriptException
     */
    public static void main(String[] args) throws ScriptException {
        String script = " print (greeting); greeting= 'Good Afternoon!' ";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        engine.put("greeting", "Good Morning!");
        if (engine instanceof Compilable) {
            Compilable compilable = (Compilable) engine;
            CompiledScript compiledScript = compilable.compile(script);
            compiledScript.eval();
            compiledScript.eval();
        }
    }
}
