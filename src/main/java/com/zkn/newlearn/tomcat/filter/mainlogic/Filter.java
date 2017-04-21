package com.zkn.newlearn.tomcat.filter.mainlogic;

    import java.io.IOException;

/**
 * Created by wb-zhangkenan on 2017/4/21.
 *
 * @date 2017/04/21
 */
public interface Filter {
    /**
     * 执行过滤器
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     */
    void doFilter(Object request, Object response,
                  FilterChain chain) throws IOException;

    void destory();
}
