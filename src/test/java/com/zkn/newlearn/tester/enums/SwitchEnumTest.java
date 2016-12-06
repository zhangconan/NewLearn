package com.zkn.newlearn.tester.enums;

import com.zkn.newlearn.enums.EnumTest01;
import org.junit.Test;

/**
 * Created by zkn on 2016/12/3.
 */
public class SwitchEnumTest {

    @Test
    public void testSwitch(){
        testSwitch01(EnumTest01.DELETE);
    }

    public void testSwitch01(EnumTest01 enumTest01){

        switch (enumTest01){
            case DELETE:
                System.out.println(EnumTest01.DELETE.getEnumDesc());
                break;
            case UPDATE:
                System.out.println(EnumTest01.UPDATE.getEnumDesc());
                break;
            case QUERY:
                System.out.println(EnumTest01.QUERY.getEnumDesc());
                break;
            default:
                System.out.println("没有符合的条件");
        }

    }
}
