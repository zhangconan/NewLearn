package com.zkn.newlearn.opensource.tomcat.filter.mainlogic.process;

import java.io.IOException;

import com.zkn.newlearn.opensource.tomcat.filter.mainlogic.FilterChain;
import com.zkn.newlearn.opensource.tomcat.filter.mainlogic.Filter;

/**
 * Created by wb-zhangkenan on 2017/4/21.
 *
 * @author wb-zhangkenan
 * @date 2017/04/21
 */
public class SecProcessFilter implements Filter {
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
        System.out.println("这是SecProcessFilter。。。。");
        chain.doFilter(request,response);
    }

    @Override
    public void destory() {

    }
}
