package com.zkn.newlearn.opensource.httpclient;

import com.google.common.collect.Lists;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.List;

public class HttpClientTest03 {

	public static void main(String[] args) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		InputStream is = null;
		String url = "http://v6.365yg.com/video/m/2202c03371cfc2c42339d437e49bdd0d12611476980000245ff95f07e8/?Expires=1496854915&AWSAccessKeyId=qh0h9TdcEMoS2oPj7aKX&Signature=O%2FDkixO4RdxsSvkqICn%2B5DoX5RA%3D";
		//封装请求参数
		List<NameValuePair> params = Lists.newArrayList();
		params.add(new BasicNameValuePair("cityEname", "henan"));
		OutputStream os = null;
		String str = "";
		try {
			//转换为键值对
			str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
			System.out.println(str);
			//创建Get请求
			HttpGet httpGet = new HttpGet(url);
			//执行Get请求，
			response = httpClient.execute(httpGet);
			//得到响应体
			HttpEntity entity = response.getEntity();
			os = new FileOutputStream("G:\\LearnVideo\\test.mp4");
			if(entity != null){
				is = entity.getContent();
				FileCopyUtils.copy(is,os);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//关闭输入流，释放资源
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//消耗实体内容
			if(response != null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//关闭相应 丢弃http连接
			if(httpClient != null){
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
