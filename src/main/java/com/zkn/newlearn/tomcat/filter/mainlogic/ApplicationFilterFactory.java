package com.zkn.newlearn.tomcat.filter.mainlogic;

import com.zkn.newlearn.tomcat.filter.mainlogic.process.FirProcessFilter;
import com.zkn.newlearn.tomcat.filter.mainlogic.process.SecProcessFilter;

/**
 * Created by zkn on 2017/4/22.
 */
public final class ApplicationFilterFactory {
    /**
     * 创建过滤器链，每个请求都会调用
     * @param request
     * @param wrapper
     * @param servlet
     */
    public static ApplicationFilterChain createFilterChain(Object request, Object wrapper, Servlet servlet){

        ApplicationFilterChain applicationFilterChain = new ApplicationFilterChain();
        //这里其实应该从配置文件中读取
        //设置Filter
        ApplicationFilterConfig filterConfig = new ApplicationFilterConfig(new FirProcessFilter());
        applicationFilterChain.addFilter(filterConfig);
        filterConfig = new ApplicationFilterConfig(new SecProcessFilter());
        applicationFilterChain.addFilter(filterConfig);
        //设置Servlet
        applicationFilterChain.setServlet(servlet);
        return applicationFilterChain;
    }
}
