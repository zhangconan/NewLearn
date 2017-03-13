package com.zkn.newlearn.complier;

import javax.tools.*;
import java.util.Arrays;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 *
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class CompilationTaskLearnSecond {

    public static void main(String[] args) {

        //获取编译器 这里用的是系统提供的编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //获取JavaFileManager 这里用的是标准的JavaFileManager
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null, null, null);
        JavaFileObject file = constructTestor();
        Iterable<? extends JavaFileObject> files = Arrays.asList(file);
        //获取CompilationTask
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, files);
        Boolean result = task.call();
        if (result == true) {
            System.out.println("Successed");
        }
    }


    private static SimpleJavaFileObject constructTestor() {
        StringBuilder contents = new StringBuilder(
                "package com.zkn.newlearn.complier;" +
                        "class CalculatorTest {\n" +
                        "  public void testMultiply() {\n" +
                        "    Calculator c = new Calculator();\n" +
                        "    System.out.println(c.multiply(2, 4));\n" +
                        "  }\n" +
                        "  public static void main(String[] args) {\n" +
                        "    CalculatorTest ct = new CalculatorTest();\n" +
                        "    ct.testMultiply();\n" +
                        "  }\n" +
                        "}\n");
        StringObject so = null;
        try {
            so = new StringObject("com.zkn.newlearn.complier.CalculatorTest", contents.toString());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return so;
    }
}
