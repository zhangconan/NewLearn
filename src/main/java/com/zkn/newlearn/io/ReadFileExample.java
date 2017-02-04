package com.zkn.newlearn.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wb-zhangkenan on 2017/2/4.
 */
public class ReadFileExample {

    public static void main(String[] args){
        byteReadFile();

    }

    private static void byteReadFile() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\wb-zhangkenan\\Desktop\\abc.txt");
            byte[] bytes = new byte[1024];
            int flag = 0;//读取内容多少的标记
            int index = 0;//统计个数
            StringBuilder stringBuilder = new StringBuilder();
            while ((flag = inputStream.read(bytes)) != -1){
                stringBuilder.append(new String(bytes,0,flag));
            }
            index = stringBuilder.indexOf("sd");
            int count = 0;
            if(index >= 0){
                do{
                    count++;
                }while ((index=stringBuilder.indexOf("sd",index+1)) > 0);
            }
            System.out.println(count);
            System.out.println(stringBuilder.toString());
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
