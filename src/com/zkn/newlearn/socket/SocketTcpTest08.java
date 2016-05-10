package com.zkn.newlearn.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 聊天客户端
 * @author zkn
 *
 */

public class SocketTcpTest08 {

	public static void main(String[] args) {
		
		Socket socket = null;
		try {
			 socket = new Socket("127.0.0.1",10006);
			 //键盘字符输入流
			 BufferedReader buffReaderKey = 
					 new BufferedReader(new InputStreamReader(System.in));
			 //字符输出流
			 PrintWriter prWriter = 
					 new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			 //字符输出流
			 BufferedReader buffReader = 
					 new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			 String str = null;
			 
			 while((str = buffReaderKey.readLine())!=null){
				 prWriter.println(str);
				 String strs = buffReader.readLine();
				 System.out.println("服务端:"+strs);
			 }
			 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
