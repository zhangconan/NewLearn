package com.zkn.newlearn.jvm.complier;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 * https://www.ibm.com/developerworks/cn/java/j-lo-jse64/index.html
 * 编译java文件
 * @date 2017/03/08
 */
public class CompilerLearnFirst {
    /**
     * JDK 6 的编译器 API 的另外一个强大之处在于，它可以编译的源文件的形式并不局限于文本文件。
     * JavaCompiler 类依靠文件管理服务可以编译多种形式的源文件。
     * 比如直接由内存中的字符串构造的文件，或者是从数据库中取出的文件。这种服务是由JavaFileManager类提供的。
     * 通常的编译过程分为以下几个步骤：
     *  1、解析 javac 的参数；
     *  2、在 source path 和/或 CLASSPATH 中查找源文件或者 jar 包；
     *  3、处理输入，输出文件；
     *  为此，新的JDK定义了javax.tools.FileObject和javax.tools.JavaFileObject接口。任何类，只要实现了这个接口，就可以被JavaFileManager识别。
     *  如果要使用JavaFileManager，就必须构造CompilationTask。JDK6提供了JavaCompiler.CompilationTask类来封装一个编译操作。
     * @param args
     */
    public static void main(String[] args){

        String fileName = "D:\\CUST\\WORK\\Exercises\\NewLearn\\src\\main\\java\\com\\zkn\\newlearn\\complier\\Target.java";
        //调用系统的编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        try {
            System.out.println(System.getProperty("user.dir"));
            //错误信息的写入位置 默认是System.getProperty("user.dir")目录下
            FileOutputStream fos = new FileOutputStream("err.txt");
            //
            compiler.run(null,null,fos,"-verbose",fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
