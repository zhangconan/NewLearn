package com.zkn.newlearn.tester.string;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by wb-zhangkenan on 2016/12/27.
 */
public class StringTest03 {

    @Test
    public void testSubString() {

        String str = "GET /zhang HTTP/1.1";
        int indexFirst = str.indexOf(" ");
        if (indexFirst != -1) {//说明查找到了
            int indexSecond = str.indexOf(" ", indexFirst + 1);
            if (indexSecond > indexFirst)
                System.out.println(str.substring(indexFirst + 1, indexSecond));
        }
        String str01 = "sdsxd";
        System.out.println(str01.substring("sds".length()));
    }

    @Test
    public void testSplitString() {

        String str = "sdsd.sdwewe.sdwewe.";
        System.out.println(Arrays.toString(str.split("\\.")));
    }

    @Test
    public void testResolve() {

        Map<String, String> parameterMap = new HashMap<>();
        String uri = "/msp/test.map?password=&name=lisi&user=zhangsan";
        //说明有参数
        int flag = -1;
        if ((flag = uri.indexOf('?')) >= 0) {
            uri = uri.substring(flag+1);
            String[] parameters = uri.split("&");
            if (parameters != null && parameters.length > 0) {
                for (int i = 0; i < parameters.length; i++) {
                    String str = parameters[i];
                    if((flag = str.indexOf('=')) >= 0){
                        String key = str.substring(0,flag);
                        String value = str.substring(flag+1);
                        parameterMap.put(key,value);
                    }else{
                        parameterMap.put(str,null);
                    }
                }
            }
        }
        parameterMap.forEach((key,value)-> System.out.println(key+" "+value));
    }
    @Test
    public void testChar(){
        char[] chars = {'a','v','c','d','d'};
        char[] chars01 = new char[chars.length];
        System.arraycopy(chars,0,chars01,0,chars.length);
        System.out.println(chars01);
    }

    @Test
    public void testLongParse(){
        System.out.println(Integer.parseInt("C8",16));
        String true_filename = "CD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpgCD/00/wKi0hVjqXGeAcyFfAAGSt-FxG-0872.jpg";
        String fileName = String.format("%s/data/%s", "tests", true_filename);
        char[] full_filename = new char[256];
        int flag = 0;
        if (fileName.length() > 256) {
            flag = 256;
            System.arraycopy(fileName.toCharArray(), 0, full_filename, 0, 256);
        } else {
            flag = fileName.length();
            System.arraycopy(fileName.toCharArray(), 0, full_filename, 0, fileName.length());
        }
        System.out.println(new String(full_filename,0,flag)+"ddd");
        File file = null;
        testFile(file);
        System.out.println(file.isDirectory());
    }

    public void testFile(File file){
        file = new File("D:\\CUST\\workspace\\C");
    }

    @Test
    public void testValue(){
        System.out.println(0x8000);
        System.out.println(0100000);

        File file = new File("D:\\sql.sql.lnk");
        System.out.println(file.isFile());
        System.out.println(file.toPath().toString());
        try {
            //Files.createLink(Paths.get("D:\\test\\"),Paths.get("D:\\sql.sql"));
            //Files.createLink(Paths.get("D:\\sql.symLink"),Paths.get("D:\\sql.sql"));
            Files.createSymbolicLink(Paths.get("D:\\test\\sql.sql.lnk"),Paths.get("D:\\test\\sqlte.sql"));
            System.out.println(Files.isSymbolicLink(Paths.get("D:\\sql.symLink")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
