package com.zkn.newlearn.complier;

import java.util.Date;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 *
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class Target {

    public void doSomething() {
        Date date = new Date(10, 3, 3);
        // 这个构造函数被标记为deprecated, 编译时会
        // 向错误输出输出信息。
        System.out.println("Doing...");
    }
}
