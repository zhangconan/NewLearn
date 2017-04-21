package com.zkn.newlearn.tomcat.filter.mainlogic;

import java.io.IOException;

/**
 * Created by wb-zhangkenan on 2017/4/21.
 *
 * @author wb-zhangkenan
 * @date 2017/04/21
 */
public class ApplicationFilterChain implements FilterChain {
    /**
     * 执行到哪一个过滤器了
     */
    private int pos = 0;

    /**
     * 一共有组装了多少个过滤器
     */
    private int n = 0;
    /**
     * 执行完过滤器之后执行的处理类
     */
    private Servlet servlet;



    /**
     * 过滤器链，执行过滤器
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public void doFilter(Object request, Object response) throws IOException {
        internalDoFilter(request,response);
    }

    public void internalDoFilter(Object request, Object response){
        if(pos < n){

        }
    }
}
