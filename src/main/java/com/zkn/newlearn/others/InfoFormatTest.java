package com.zkn.newlearn.others;

/**
 * Created by wb-zhangkenan on 2017/6/8.
 *
 * @author wb-zhangkenan
 * @date 2017/06/08
 */
public class InfoFormatTest {

    public static final String INFO_FORMAT
        = "[THREAD_INFO] %d %s [INVOKE_METHOD] %s [OPERATE_EMPID] %s [EVENT] %s [%s] %s ";

    public static void main(String[] args) {
        System.out.println(String
            .format(INFO_FORMAT, Thread.currentThread().getId(), Thread.currentThread().getName(), "main", "zhangsan",
                "测试main方法", "RESULT", "TEST"));
    }
}
