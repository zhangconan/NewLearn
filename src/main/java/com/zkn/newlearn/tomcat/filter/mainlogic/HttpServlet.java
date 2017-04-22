package com.zkn.newlearn.tomcat.filter.mainlogic;

/**
 * Created by zkn on 2017/4/21.
 */
public class HttpServlet implements Servlet{
    /**
     * 模拟Servlet的service方法
     *
     * @param request
     * @param response
     */
    @Override
    public void service(Object request, Object response) {
        System.out.println("这是HttpServlet的service方法。。。。");
    }
}
