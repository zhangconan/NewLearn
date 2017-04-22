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
     * 过滤器数组
     */
    private ApplicationFilterConfig[] filters = new ApplicationFilterConfig[0];
    /**
     * 每次增加的长度
     */
    public static final int INCREMENT = 10;

    /**
     * 过滤器链，执行过滤器
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public void doFilter(Object request, Object response) throws IOException {
        //@TODO 这里可以写一些逻辑处理
        internalDoFilter(request, response);
    }

    public void internalDoFilter(Object request, Object response) throws IOException {
        if (pos < n) {
            //过滤器的处理
            ApplicationFilterConfig filterConfig = filters[pos++];
            Filter filter = filterConfig.getFilter();
            filter.doFilter(request,response,this);
            return;
        }
        servlet.service(request,response);
    }
    /**
     * 添加过滤器
     * @param filterConfig
     */
    public void addFilter(ApplicationFilterConfig filterConfig){
        //过滤掉重复的Filter
        for(int i=0;i<filters.length;i++){
            if(filters[i] == filterConfig){
                return;
            }
        }
        //数组扩容
        if( n == filters.length){
            ApplicationFilterConfig[] newFilters = new ApplicationFilterConfig[n + INCREMENT];
            System.arraycopy(filters,0,newFilters,0,n);
            filters = newFilters;
        }
        filters[n++] = filterConfig;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

    public void release() {
        for (int i = 0; i < n; i++) {
            filters[i] = null;
        }
        n = 0;
        pos = 0;
        servlet = null;
    }
}
