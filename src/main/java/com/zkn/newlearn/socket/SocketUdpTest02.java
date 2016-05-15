package com.zkn.newlearn.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * @author zkn
 *
 */

public class SocketUdpTest02 {

	public static void main(String[] args) {
		
		try {
			/**
			 * 绑定端口号
			 */
			DatagramSocket ds = new DatagramSocket(11111);
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			ds.receive(dp);
			String str = new String(buf,0,dp.getLength());
			System.out.println(str+" "+dp.getPort());
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
