package com.zkn.newlearn.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * @author zkn
 *
 */

public class SocketTcpTest02 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",10003);
			OutputStream os = socket.getOutputStream();
			String str = "你好啊";
			os.write(str.getBytes());
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
