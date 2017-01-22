package com.zkn.newlearn.thread.multithread.art;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by zkn on 2017/1/22.
 * 管道输入输出流：
 *  一共有四种管道流：PipedOutputStream、PipedInputStream、PipedReader、PipedWriter
 */
public class PipedInputAndOutput {

    public static void main(String[] args){

        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将管道输入输出流连接起来
        try {
            out.connect(in);
            Thread printThread = new Thread(new Print(in),"PrintThread");
            printThread.start();
            int receive = 0;
            while ((receive = System.in.read()) != -1){
                out.write(receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Print implements Runnable {
    private PipedReader in;

    public Print(PipedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        int receive = 0;
        try {
            while ((receive = in.read()) != -1){
                System.out.println((char)receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
