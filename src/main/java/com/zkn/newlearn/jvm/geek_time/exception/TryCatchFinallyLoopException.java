package com.zkn.newlearn.jvm.geek_time.exception;

/**
 * @author zkn
 * @date 2018/8/8 23:25
 **/
public class TryCatchFinallyLoopException {

    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        for (int i = 0; i < 100; i++) {
            try {
                tryBlock = 0;
                if (i < 50) {
                    continue;
                } else if (i < 80) {
                    break;
                } else {
                    return;
                }
            } catch (Exception e) {
                catchBlock = 1;
            } finally {
                finallyBlock = 2;
            }
        }
        methodExit = 3;
    }
}
