package com.zkn.newlearn.tomcat.filter.mainlogic;

import java.io.IOException;

/**
 * Created by wb-zhangkenan on 2017/4/21.
 *
 * @author wb-zhangkenan
 * @date 2017/04/21
 */
public interface FilterChain {
    /**
     * 过滤器链，执行过滤器
     * @param request
     * @param response
     * @throws IOException
     */
    void doFilter(Object request, Object response)
        throws IOException;
}
