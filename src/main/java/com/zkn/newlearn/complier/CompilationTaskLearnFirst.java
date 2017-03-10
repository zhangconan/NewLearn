package com.zkn.newlearn.complier;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.util.Arrays;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 *
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class CompilationTaskLearnFirst {

    public static void main(String[] args) {

        String fileName = "D:\\CUST\\WORK\\Exercises\\NewLearn\\src\\main\\java\\com\\zkn\\newlearn\\complier\\Calculator.java";
        //获取编译器 这里用的是系统提供的编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //获取JavaFileManager 这里用的是标准的JavaFileManager
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> files =
                fileManager.getJavaFileObjectsFromStrings(Arrays.asList(fileName));
        //获取CompilationTask
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, files);
        Boolean result = task.call();
        if (result == true) {
            System.out.println("Successed");
        }
    }
}
