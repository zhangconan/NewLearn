package com.zkn.newlearn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author zkn
 *
 */

public class SocketTcpTest09 {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			 server = new ServerSocket(10005);
			 Socket socket = server.accept();
			 System.out.println(socket.getInetAddress().getHostAddress());
			 InputStream is = socket.getInputStream();
			 byte[] bt = new byte[1024];
			 int len = is.read(bt);
			 System.out.println(new String(bt,0,len));
			 PrintWriter writer = 
					 new PrintWriter(socket.getOutputStream(),true);
			 writer.println("<font color='red' size='20'>dddd</font>");
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
