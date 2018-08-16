package com.zkn.newlearn.opensource.tomcat.filter.mainlogic;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by zkn on 2017/4/22.
 */
public class TestFilter {

    @Test
    public void testFilter(){
        ApplicationFilterChain filterChain = ApplicationFilterFactory.createFilterChain(null,null,new HttpServlet());
        try {
            filterChain.doFilter(null,null);
            filterChain.release();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
