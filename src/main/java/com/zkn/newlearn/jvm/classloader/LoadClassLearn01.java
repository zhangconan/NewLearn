package com.zkn.newlearn.jvm.classloader;

/**
 * Created by zkn on 2016/12/25.
 */
public class LoadClassLearn01 {

    public static void main(String[] args){

        try {
            Class clazz = LoadClassLearn01.class.getClassLoader().loadClass("com.zkn.newlearn.system.SystemVariableLearn01");
            Object object = clazz.newInstance();
            //System.out.println(object.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
