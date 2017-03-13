package com.zkn.newlearn.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 * https://www.ibm.com/developerworks/cn/java/j-lo-jse66/
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class HelloWorld {

    public static void main(String[] args){

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {
            engine.eval("print('Hello World')");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        //reader(args[0],args[1]);
    }

    public static void reader(String script,String file){

        try {
            FileReader fileReader = new FileReader(new File(file));
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName(script);
            engine.eval(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }

}
