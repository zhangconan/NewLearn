package com.zkn.newlearn.opensource.tomcat.filter.mainlogic;

import java.io.Serializable;

/**
 * Created by wb-zhangkenan on 2017/4/21.
 *
 * @author wb-zhangkenan
 * @date 2017/04/21
 */
public class ApplicationFilterConfig implements FilterConfig,Serializable {

    /**
     * 设置过滤器
     */
    private Filter filter;

    public Filter getFilter() {
        return filter;
    }

    public ApplicationFilterConfig(Filter filter) {
        this.filter = filter;
    }
}
