package com.zkn.newlearn.tester.io;

import java.io.PrintStream;

/**
 * Created by wb-zhangkenan on 2017/2/10.
 */
public class OverridePrintStream {

    public static void main(String[] args){

        int a = 10;
        int b = 20;
        method(a,b);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }

    private static void method(int a, int b) {

        PrintStream ps = new PrintStream(System.out){
            @Override
            public void println(String x){
                if(x!=null && ("a=10".equals(x) || "b=20".equals(x))){
                    String[] str = x.split("=");
                    int temp = Integer.parseInt(str[1]);
                    temp = temp*10;
                    super.println(str[0]+"="+temp);
                }else {
                    super.println(x);
                }
            }
        };
        System.setOut(ps);
    }
}
