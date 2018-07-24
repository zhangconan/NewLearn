package com.zkn.newlearn.spi;

/**
 * @author zkn
 * @date 2018/7/24 23:23
 **/
public class SpiServiceSec implements SpiService {

    @Override
    public void testSpi() {
        System.out.println("我是第二个SPI服务");
    }
}
