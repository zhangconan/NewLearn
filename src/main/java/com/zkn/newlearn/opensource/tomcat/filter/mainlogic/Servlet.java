package com.zkn.newlearn.opensource.tomcat.filter.mainlogic;

/**
 * Created by wb-zhangkenan on 2017/4/21.
 *
 * @author wb-zhangkenan
 * @date 2017/04/21
 */
public interface Servlet {
    /**
     * 模拟Servlet的service方法
     * @param request
     * @param response
     */
    void service(Object request, Object response);
}
