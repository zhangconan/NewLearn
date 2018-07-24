package com.zkn.newlearn.spi.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.cluster.LoadBalance;

/**
 * @author zkn
 * @date 2018/7/25 0:11
 **/
public class ExtensionLoaderMain {

    public static void main(String[] args) {
        LoadBalance loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("custom");
        loadBalance.select(null, null, null);
    }
}
