package com.zkn.newlearn.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ����ͻ���
 * @author zkn
 *
 */

public class SocketTcpTest08 {

	public static void main(String[] args) {
		
		Socket socket = null;
		try {
			 socket = new Socket("127.0.0.1",10006);
			 //�����ַ�������
			 BufferedReader buffReaderKey = 
					 new BufferedReader(new InputStreamReader(System.in));
			 //�ַ������
			 PrintWriter prWriter = 
					 new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			 //�ַ������
			 BufferedReader buffReader = 
					 new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			 String str = null;
			 
			 while((str = buffReaderKey.readLine())!=null){
				 prWriter.println(str);
				 String strs = buffReader.readLine();
				 System.out.println("�����:"+strs);
			 }
			 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
