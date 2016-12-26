package com.zkn.newlearn.system;

import java.io.File;
import java.io.IOException;

/**
 * Created by zkn on 2016/12/24.
 */
public class SystemVariableLearn01 {

    public static void main(String[] args){
        new SystemVariableLearn01().testLoad();
        System.out.println(System.getProperty("user.dir"));
        try {
            System.setProperty
                    ("catalina.home",
                            (new File(System.getProperty("user.dir"), ".."))
                                    .getCanonicalPath());

            System.out.println(System.getProperty("catalina.home"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void testLoad(){
        System.out.println("我被调用了");
    }
}
