package com.zkn.newlearn.opensource.httpclient;

import java.io.*;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

/**
 * Created by wb-zhangkenan on 2017/5/25.
 * http://www.baeldung.com/httpclient-multipart-upload
 *
 * @author wb-zhangkenan
 * @date 2017/05/25
 */
public class HttpClientUploadFile {

    public static void main(String[] args) {
        //inputStreamUpload();
        //fileUpload();
    }

    /**
     * File文件上传
     */
    @Test
    public  void fileUpload() {
        //构建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //构建POST请求
        HttpPost httpPost = new HttpPost("http://localhost:8003/uploadAndDownload/uploadFileAction");
        InputStream inputStream = null;
        try {
            //要上传的文件
            File file = null; file = new File("G:\\qqq.txt");
            //构建文件体
            FileBody fileBody = new FileBody(file,ContentType.MULTIPART_FORM_DATA,"qqq.txt");
            StringBody stringBody = new StringBody("12",ContentType.MULTIPART_FORM_DATA);
            HttpEntity httpEntity = MultipartEntityBuilder
                    .create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addPart("uploadFile", fileBody)
                    .addPart("id",stringBody).build();
            httpPost.setEntity(httpEntity);
            //发送请求
            HttpResponse response = client.execute(httpPost);
            httpEntity = response.getEntity();
            if(httpEntity != null){
                inputStream = httpEntity.getContent();
                //转换为字节输入流
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Consts.UTF_8));
                String body = null;
                while ((body = br.readLine()) != null) {
                    System.out.println(body);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * InputStream文件上传
     */
    @Test
    public void inputStreamUpload() {
        //创建HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //构建POST请求   请求地址请更换为自己的。
        //1)
        HttpPost post = new HttpPost("http://localhost:8003/uploadAndDownload/uploadFileAction");
        InputStream inputStream = null;
        try {
            //文件路径请换成自己的
            //2)
            inputStream = new FileInputStream("G:\\LearnVideo\\text01.txt");
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            //第一个参数为 相当于 Form表单提交的file框的name值
            //第三个参数是文件名
            //3)
            builder.addBinaryBody("uploadFile", inputStream, ContentType.create("multipart/form-data"), "text01.txt");
            //4)构建请求参数 普通表单项
            StringBody stringBody = new StringBody("12",ContentType.MULTIPART_FORM_DATA);
            builder.addPart("id",stringBody);
            HttpEntity entity = builder.build();
            post.setEntity(entity);
            //发送请求
            HttpResponse response = client.execute(post);
            entity = response.getEntity();
            if (entity != null) {
                inputStream = entity.getContent();
                //转换为字节输入流
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, Consts.UTF_8));
                String body = null;
                while ((body = br.readLine()) != null) {
                    System.out.println(body);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
