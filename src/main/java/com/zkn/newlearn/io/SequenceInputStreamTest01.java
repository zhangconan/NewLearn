package com.zkn.newlearn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

/**
 * SequenceInputStream 可以把两个输入流合并成一个输入流
 * @author zkn
 *
 */

public class SequenceInputStreamTest01 {

	public static void testSequence() throws Exception{
		InputStream is1 = new FileInputStream(new File("D:\\log4j\\edp-console.log"));
		InputStream is2 = new FileInputStream(new File("D:\\log4j\\log4j.log"));
		
		SequenceInputStream sequence = new SequenceInputStream(is1, is2);
		OutputStream os = new FileOutputStream(new File("D:\\log4j\\log.log"));
		int ch = 0;
		while((ch = sequence.read())!=-1){
			os.write(ch);
		}
		is1.close();
		is2.close();
		sequence.close();
		os.close();
	}
	
	public static void main(String[] args) {
		try {
			testSequence();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
