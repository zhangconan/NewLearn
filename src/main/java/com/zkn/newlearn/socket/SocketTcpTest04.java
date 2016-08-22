package com.zkn.newlearn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端
 * @author zkn
 *
 */

public class SocketTcpTest04 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",10003);
			OutputStream os = socket.getOutputStream();
			Scanner sc = new Scanner(System.in);
			/**
			while(true){
				
				String str = sc.nextLine();
				os.write(str.getBytes());
				if("end".equals(str)){
					return;
				}
			}
			*/
			String str = sc.nextLine();
			os.write(str.getBytes());
			
			InputStream is = socket.getInputStream();
			byte[] bt = new byte[1024];
			int len = is.read(bt);
			String strs = new String(bt, 0, len);
			System.out.println(strs);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
