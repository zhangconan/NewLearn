package com.zkn.newlearn.jvm.geek_time.exception;

/**
 * @author zkn
 * @date 2018/8/8 23:10
 **/
public class TryCatchFinallyException {

    private static int tryBlock;

    private static int catchBlock;

    private static int finallyBlock;

    private static int methodExit;

    public static void main(String[] args) {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
        }
        methodExit = 3;
    }
}
