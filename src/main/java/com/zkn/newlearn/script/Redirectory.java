package com.zkn.newlearn.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 *
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class Redirectory {

    public static void main(String[] args) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        PipedReader pr = new PipedReader();
        PipedWriter pw = null;
        try {
            pw = new PipedWriter(pr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter writer = new PrintWriter(pw);
        engine.getContext().setWriter(writer);
        String script = "print ('Hello from JavaScript')";
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(pr);
        try {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
