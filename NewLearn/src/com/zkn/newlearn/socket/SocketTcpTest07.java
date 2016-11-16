package com.zkn.newlearn.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天服务端
 * @author zkn
 *
 */

public class SocketTcpTest07 {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(10006);
			Socket socket = server.accept();
			
			//字符输入流
			BufferedReader buffReader = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			/**
			//键盘输入流
			BufferedReader buffReaderKey = 
					new BufferedReader(new InputStreamReader(System.in));
			*/
			//字符输出流
			BufferedWriter buffWriter = 
					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String str = null;
			while((str = buffReader.readLine())!=null){
				System.out.println("客户端:"+str);
				//String strs = buffReaderKey.readLine();
				buffWriter.write("回复:"+str);
				buffWriter.newLine();
				buffWriter.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(server != null){
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
