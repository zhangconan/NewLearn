package com.zkn.newlearn.lambda;

import java.util.Map;

/**
 * Created by zkn on 2017/7/24.
 */
public class InterfaceFiledDomain {

    /**
     * 函数式接口:接口中只能有一个方法。
     */
    private ConsumerAccept<Map<String,String>> consumerAccept;

    public ConsumerAccept<Map<String, String>> getConsumerAccept() {
        return consumerAccept;
    }

    public void setConsumerAccept(ConsumerAccept<Map<String, String>> consumerAccept) {
        this.consumerAccept = consumerAccept;
    }


}
