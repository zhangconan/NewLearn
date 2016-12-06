package com.zkn.newlearn.bytes;

/**
 * Created by wb-zhangkenan on 2016/12/6.
 */
public class BytesTest01 {

    public static void main(String[] args){
        //byte是一个字节 八位
        byte a = 12;
        byte b = 13;
        byte c = -127;
        byte e = -128;
        //int是4个字节 32位 一个int可以用来表示 4个byte
        //0xff 是 1111 1111 和byte(与) & 的时候 所得到的结果是 byte原值
        //即任何byte值和0xff与(&)，值不变
        /**
         * 下面这步操作的意思是：一个int分为4个8为：
         *  如右面所示：0 0 0 0 0 0 0 0  0 0 0 0 0 0 0 0  0 0 0 0 0 0 0 0  0 0 0 0 0 0 0 0
         *  从右往左 最低8位用来存储a的值，接着的8为用来存储b的值，再接着的8为用来存储c的值
         */
        int d = a & 0xff | (b & 0xff) << 8 | (c & 0xff) << 16 | (e & 0xff) << 24;
        System.out.println(d);
        System.out.println((byte)(d & 0xff));//取出a的值
        System.out.println((byte)((d >>> 8) & 0xff));//取出b的值
        System.out.println((byte)((d >>> 16) & 0xff));//取出c的值
        System.out.println((byte)((d >>> 24) & 0xff));//取出e的值
    }
}
