package com.zkn.newlearn.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 发送端
 * @author zkn
 *
 */

public class SocketUdpTest01 {

	public static void main(String[] args) {
		
		try {
			String str = "你好啊。。。。";
			DatagramSocket ds = new DatagramSocket();
			byte[] buf = str.getBytes();  
			ds.send(new DatagramPacket(buf, buf.length,InetAddress.getByName("127.0.0.1"),11111));
			ds.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
