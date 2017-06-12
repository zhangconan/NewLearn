package com.zkn.newlearn.rpc.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by zkn on 2017/6/12.
 */
public class Consumer {

    public static void main(String[] args){
        //服务接口类
        String interfaceName = SayHelloService.class.getName();
        ObjectOutputStream oos = null;
        try {
            //要远程调用的方法
            Method methodInfo = SayHelloService.class.getMethod("sayHello",String.class);
            //参数
            Object[] arguments = {"Hello!"};
            //客户端
            Socket socket = new Socket("127.0.0.1",12345);
            //序列化对象
            oos = new ObjectOutputStream(socket.getOutputStream());
            //把信息序列化
            oos.writeUTF(interfaceName);
            oos.writeUTF(methodInfo.getName());
            oos.writeObject(methodInfo.getParameterTypes());
            oos.writeObject(arguments);
            //反序列化获取结果集
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object result = ois.readObject();
            System.out.println(result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
