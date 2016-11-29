package com.zkn.newlearn.tester.collections;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by wb-zhangkenan on 2016/11/22.
 */
public class GuavaTest01 {

    @Test
    public void testJoner(){
        String[] str = {"sss","ddd","sdsdwe"};
        List<String> list = new ArrayList<String>(){
            {
                add("sss");
                add("ddd");
            }
        };
        System.out.println(Joiner.on(",").join(str));
        List<String> admins = Lists.newArrayList(Arrays.asList(str));
        admins.removeAll(list);
        System.out.println(Arrays.toString(admins.toArray()));
        Map<String,String> map = Maps.uniqueIndex(admins, new Function<String,String>(){
            @Override
            public String apply(String input) {
                return input;
            }
        });
        System.out.println(map.get("sdsdwe"));

        Map<String,String> maps = Maps.newHashMap();
        maps.put("zhangsan","张三");
        maps.put("zhangsan1","张三1");
        maps.put("zhangsan2","张三2");
        maps.put("zhangsan3","张三3");
        for(Map.Entry<String,String> entry : maps.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
