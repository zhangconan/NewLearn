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
 * �ͻ���
 * @author zkn
 *
 */

public class SocketTcpTest06 {

	public static void main(String[] args) {
		
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",10008);
			//�����ַ�������  �ֽ����������ַ��������໥ת�����м���InputStreamReader
			BufferedReader buffReader = 
					new BufferedReader(new InputStreamReader(System.in));
			//�ַ������  �ֽ���������ַ�������໥ת�����м��� OutputStreamReader
			/*
			BufferedWriter buffWriter = 
					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			 */
			BufferedReader buffr = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter prWriter = 
					new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			
			String line = null;
			while((line=buffReader.readLine())!=null){
				if("end".equals(line))
					break;
				/*
				buffWriter.write(line);
				buffWriter.newLine();  //�൱�ڻس���
				buffWriter.flush();
				*/
				prWriter.println(line);
				String str = buffr.readLine();
				System.out.println("�����:"+str);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
