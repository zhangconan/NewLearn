package com.zkn.newlearn.spi;

import java.util.ServiceLoader;

/**
 * @author zkn
 * @date 2018/7/24 23:25
 **/
public class SpiServiceMain {

    public static void main(String[] args) {
        //获取SPI服务
        ServiceLoader<SpiService> spiServices = ServiceLoader.load(SpiService.class);
        for (SpiService spiService : spiServices) {
            spiService.testSpi();
        }
    }
}
