package com.zkn.newlearn.tester.collections;

import com.zkn.newlearn.domain.TeamInfoDomain;
import org.junit.Test;

import java.util.*;

/**
 * Created by wb-zhangkenan on 2016/12/6.
 */
public class CollectionRemoveSunTest {

    @Test
    public void testRemoveSun(){

        List<TeamInfoDomain> list = new ArrayList<TeamInfoDomain>(){{
            add(new TeamInfoDomain(5L,"1,2,3"));
            add(new TeamInfoDomain(11L,null));
            add(new TeamInfoDomain(6L,"1,2,3,5"));
            add(new TeamInfoDomain(7L,"1,2,3"));
            add(new TeamInfoDomain(8L,"1,2,3,4"));
            add(new TeamInfoDomain(9L,"1,2,3,5"));
            add(new TeamInfoDomain(1L,null));
            add(new TeamInfoDomain(12L,"11"));
        }};
        Set<Long> set = new HashSet<Long>();
        for(int i=0;i<list.size()-1;i++){
            for(int j=i;j<list.size();j++){
                if(!StringUtil.isEmpty(list.get(j).getTeamPath()) && Arrays.asList(list.get(j).getTeamPath().split(",")).contains(list.get(i).getTeamId()+"")){
                    //说明j是i的子节点
                    set.add(list.get(j).getTeamId());
                }else if(!StringUtil.isEmpty(list.get(i).getTeamPath()) && Arrays.asList(list.get(i).getTeamPath().split(",")).contains(list.get(j).getTeamId()+"")){
                    set.add(list.get(i).getTeamId());
                }
            }
        }
        System.out.println(Arrays.toString(set.toArray(new Long[0])));
        System.out.println(Arrays.toString((new ArrayList<Long>(set)).toArray()));
    }

    private static class StringUtil{

        public static boolean isEmpty(String str){
            if(str == null || str.length() == 0)
                return true;
            return false;
        }
    }
}
