package com.zkn.newlearn.tester.json;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wb-zhangkenan on 2016/10/8.
 */
public class TestJson01 {

    public static void main(String[] args){
        String str = "{\"totalPage\":\"5\",\"pageSize\":\"1\",\"wantSendOppRefresh\":\"1\",\"tables\":[\"customer\"]}";
        Map<String, Object> sMap = JSON.parseObject(str, Map.class);
        List<String> strArr = (List<String>) sMap.get("tables");
        System.out.println(strArr.toString());
        System.out.println(strArr.toString());

        List<String> strList = new ArrayList<String>();
        strList.add("dddd");
        strList.add("ddddw2222");
        strList.add("dddqqqqq");
        System.out.println(JSON.toJSONString(strList));

        String[] strs = {"dddd","ddddw2222","dddqqqqq"};
        System.out.println(JSON.toJSONString(strs));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = sdf.parse("2016-10-10 15:34:03");
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(-1 % 2);
    }

}
