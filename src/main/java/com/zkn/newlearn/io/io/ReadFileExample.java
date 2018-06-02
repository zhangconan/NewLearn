package com.zkn.newlearn.io.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by wb-zhangkenan on 2017/2/4.
 */
public class ReadFileExample {

    public static void main(String[] args){
        byteReadFile();

    }

    private static void byteReadFile() {
        LineNumberReader inputStream = null;
        try {
            inputStream = new LineNumberReader(new InputStreamReader(new FileInputStream("D:\\centOs\\VirtualBoxVMs"
                + "\\CentOs\\ZknCentOs.vdi")));
            byte[] bytes = new byte[1024];
            int flag = 0;//读取内容多少的标记
            int index = 0;//统计个数
            StringBuilder stringBuilder = new StringBuilder();
            System.out.println(inputStream.getLineNumber());
            String str = null;
            while((str = inputStream.readLine())!=null){
                System.out.println(str);
            }
            System.out.println("读完了。。。。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
