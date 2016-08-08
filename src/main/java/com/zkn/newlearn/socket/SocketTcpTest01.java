package com.zkn.newlearn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author pc
 *
 */

public class SocketTcpTest01 {
 
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(10003);
			Socket socket = server.accept();
			InputStream is = socket.getInputStream();
			byte[] bt = new byte[1024];
			int len = is.read(bt);
			String str = new String(bt,0,len);
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
