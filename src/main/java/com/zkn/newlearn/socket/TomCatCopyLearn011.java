package com.zkn.newlearn.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zkn on 2016/12/22.
 */
public class TomCatCopyLearn011 {

    public static void main(String[] args){
        Thread thread = new Thread(new ServerSocketRunnable());
        thread.start();
    }

    private static class ServerSocketRunnable implements Runnable{

        @Override
        public void run() {
            ServerSocket serverSocket = null;
            PrintWriter pw = null;
            while(true){
                try {
                    serverSocket = new ServerSocket(8001);
                    Socket socket = serverSocket.accept();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String headerStr = null;
                    while ((headerStr = bufferedReader.readLine()) != null ){
                        if("".equals(headerStr)) {
                            break;
                        }
                        System.out.println(new String(headerStr));
                    }
                    String str = new String("张三你好啊");
                    pw = new PrintWriter(socket.getOutputStream());
                    pw.println("HTTP/1.1 200 OK ");
                    pw.println("Context-Type:text/html;charset=utf-8");
                    pw.println("Content-Length:"+str.getBytes("utf-8").length);
                    pw.println("");
                    pw.println(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(pw != null) {
                        pw.close();
                    }
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
