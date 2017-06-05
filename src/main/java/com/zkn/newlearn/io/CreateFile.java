package com.zkn.newlearn.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wb-zhangkenan on 2017/6/1.
 *
 * @author wb-zhangkenan
 * @date 2017/06/01
 */
public class CreateFile {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    public static void main(String[] args) {

        File file = new File("D:\\home\\admin\\test0\\");
        if (!file.exists()) {
            file.mkdirs();
        }
        File createFile = new File(file, sdf.format(new Date()) + ".csv");
        if (!createFile.exists()) {
            try {
                createFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
