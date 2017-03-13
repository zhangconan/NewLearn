package com.zkn.newlearn.complier;

import javax.tools.*;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 *
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class CompilerWithListener {

    public static void main(String[] args) throws Exception {
        String fullQuanlifiedFileName = "D:\\CUST\\WORK\\Exercises\\NewLearn\\src\\main\\java\\com\\zkn\\newlearn\\complier\\Calculator.java";
        //获取JavaCompiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //获取JavaFileManager StandardJavaFileManager
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null, null, null);
        //需要编译的文件
        Iterable<? extends JavaFileObject> files =
                fileManager.getJavaFileObjectsFromStrings(
                        Arrays.asList(fullQuanlifiedFileName));
        //编辑器的信息
        DiagnosticCollector<JavaFileObject> collector =
                new DiagnosticCollector<>();
        //获取CompilationTask
        JavaCompiler.CompilationTask task =
                compiler.getTask(null, fileManager, collector, null, null, files);

        Boolean result = task.call();
        List<Diagnostic<? extends JavaFileObject>> diagnostics =
                collector.getDiagnostics();
        for (Diagnostic<? extends JavaFileObject> d : diagnostics) {
            System.out.println("Line Number->" + d.getLineNumber());
            System.out.println("Message->" +
                    d.getMessage(Locale.ENGLISH));
            System.out.println("Source" + d.getCode());
            System.out.println("\n");
        }

        if (result == true) {
            System.out.println("Succeeded");
        }
    }
}
