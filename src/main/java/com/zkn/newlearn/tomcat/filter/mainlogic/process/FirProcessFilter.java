package com.zkn.newlearn.tomcat.filter.mainlogic.process;

import java.io.IOException;

import com.zkn.newlearn.tomcat.filter.mainlogic.Filter;
import com.zkn.newlearn.tomcat.filter.mainlogic.FilterChain;

/**
 * Created by wb-zhangkenan on 2017/4/21.
 *
 * @author wb-zhangkenan
 * @date 2017/04/21
 */
public class FirProcessFilter implements Filter {
    /**
     * 执行过滤器
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     */
    @Override
    public void doFilter(Object request, Object response, FilterChain chain) throws IOException {

    }

    @Override
    public void destory() {

    }
}
