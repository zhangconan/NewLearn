package com.zkn.newlearn.tester.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zkn on 2016/12/18.
 * 里氏代换原则：所有适用父类的地方都可以用子类来进行代换。
 *               子类的方法参数应比父类的方法参数更宽泛。
 */
public class Father {

    public void testMap(Map map){

    }

    public static void main(String[] args){
        int count = 0;
        for(int i=0;i<10;i++){
            count = count++;
        }
        System.out.println(count);
    }
}
class Sun extends Father{

    public void testMap(HashMap map){

    }
}