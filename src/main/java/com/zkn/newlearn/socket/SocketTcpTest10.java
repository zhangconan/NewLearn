package com.zkn.newlearn.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by zkn on 2017/2/25.
 */
public class SocketTcpTest10 {
    public static void main(String[] args) {

        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 10008);
            //键盘字符输入流  字节输入流和字符输入流相互转换的中间类InputStreamReader
            BufferedReader buffReader =
                    new BufferedReader(new InputStreamReader(System.in));
            //字符输出流  字节输出流和字符输出流相互转换的中间类 OutputStreamReader
            /*
			BufferedWriter buffWriter =
					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			 */
            BufferedReader buffr =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter prWriter =
                    new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            String line = null;
            while ((line = buffReader.readLine()) != null) {
                if ("end".equals(line)) {
                    break;
                }
				/*
				buffWriter.write(line);
				buffWriter.newLine();  //相当于回车键
				buffWriter.flush();
				*/
                prWriter.println(line);
                String str = buffr.readLine();
                System.out.println("服务端ss:" + str);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
