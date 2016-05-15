package com.zkn.newlearn.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author zkn
 *
 */

public class SocketTest02 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",10003);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
