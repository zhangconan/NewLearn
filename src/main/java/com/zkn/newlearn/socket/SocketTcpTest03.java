package com.zkn.newlearn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author zkn
 *
 */

public class SocketTcpTest03 {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(10003);
			Socket socket = server.accept();
			InputStream is = socket.getInputStream();
			byte[] bt = new byte[1024];
			int len = is.read(bt);
			String str = new String(bt,0,len);
			System.out.println(str);
			
			OutputStream os = socket.getOutputStream();
			os.write("客户端,你好".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(server != null){
					server.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
