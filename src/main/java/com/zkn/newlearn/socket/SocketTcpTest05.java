package com.zkn.newlearn.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author zkn
 *
 */

public class SocketTcpTest05 {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			 server = new ServerSocket(10008);
			 Socket socket = server.accept();
			 
			 BufferedReader buffReader = 
					 new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 BufferedWriter buffWriter = 
					 new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			 String str = null;
			 while((str=buffReader.readLine())!=null){
				 System.out.println("客户端:"+str);
				 str = str.toUpperCase();
				 buffWriter.write(str);
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
