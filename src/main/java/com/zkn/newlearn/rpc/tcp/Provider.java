package com.zkn.newlearn.rpc.tcp;

import org.apache.commons.collections.map.HashedMap;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * Created by zkn on 2017/6/12.
 */
public class Provider {
    /**
     * 存放所有的提供者
     */
    private static Map<String, Object> providerService = new HashedMap();

    static {
        //初始化提供者
        providerService.put(SayHelloService.class.getName(), new SayHelloServiceImpl());
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //服务端
            serverSocket = new ServerSocket(12345);
            Socket socket = null;
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            while (true) {
                //收到一个连接
                socket = serverSocket.accept();
                //反序列化结果信息
                ois = new ObjectInputStream(socket.getInputStream());
                //接口的名称
                String interfaceName = ois.readUTF();
                //调用的方法名称
                String methodName = ois.readUTF();
                //参数类型
                Object argumentTyps = ois.readObject();
                //参数
                Object[] arguments = (Object[]) ois.readObject();
                //服务
                Object service = providerService.get(interfaceName);
                Class<?> clazz = Class.forName(interfaceName);
                //获取方法信息
                Method method = clazz.getMethod(methodName, (Class<?>[]) argumentTyps);
                //反射调用
                Object result = method.invoke(service,arguments);
                //序列化结果集
                oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
