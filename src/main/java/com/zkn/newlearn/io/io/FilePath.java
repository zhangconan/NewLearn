package com.zkn.newlearn.io.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zkn on 2017/7/29.
 */
public class FilePath {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"));
        File file = new File(System.getProperty("user.dir"));
        testFile(file);
    }

    public static void testFile(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File fi : files){
                testFile(fi);
            }
        }
        if(file.getPath().endsWith(".class")){
            System.out.println(file.getAbsolutePath());
        }
    }
}
