package com.zkn.newlearn.jdk7.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;

/**
 * Created by wb-zhangkenan on 2017/8/23.
 *
 * @author wb-zhangkenan
 * @date 2017/08/23
 */
public class CreateMethodType {
    /**
     * 第一种获取MethodType的方式。
     * 根据返回值和参数获取MethodType。
     * 第一个参数为返回值类型，后面跟着0到多个参数类型。
     */
    public static void generateMethodType() {
        MethodType mt1 = MethodType.methodType(int.class);
        MethodType mt2 = MethodType.methodType(String.class, String.class);
        MethodType mt3 = MethodType.methodType(Void.class, String.class);
    }

    /**
     * 第二种获取MethodType对象的方式。
     * 返回值和所有参数的类型都是Object类。
     */
    public static void generateGenericMethodTypes() {
        //3个类型为Object的参数
        MethodType mt1 = MethodType.genericMethodType(3);
        //2个类型为Object的参数和后面的Object[]类型的参数.
        MethodType mt2 = MethodType.genericMethodType(2, true);
    }

    /**
     * 第三种方式：字节码的形式。
     */
    public static void generateMethodTypesFromDescriptor() {
        ClassLoader cl = CreateMethodType.class.getClassLoader();
        String descriptor = "(Ljava/lang/String;)Ljava/lang/String;";
        MethodType mt1 = MethodType.fromMethodDescriptorString(descriptor, cl);
    }

    public static void invokeExact() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle methodHandle = lookup.findVirtual(String.class, "substring", methodType);
        System.out.println((String)methodHandle.invokeExact("zhangsanli", 1, 2));
    }

    public void normalMethod(String str, int args, int[] arr) {
        System.out.println("我被调用了....." + str + " " + args + " " + Arrays.toString(arr));
    }

    public void normalMethod(String str, int args, int args1, int args2) {
        System.out.println("我被调用了....." + str + " " + args + " " + args1 + " " + args2);
    }

    /**
     * 可变参数的句柄 最后一根可变参数转换为数组
     */
    public void asVarargsCollector() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, String.class, int.class, int[].class);
        MethodHandle methodHandle = null;
        try {
            methodHandle = lookup.findVirtual(CreateMethodType.class, "normalMethod", methodType);
            methodHandle = methodHandle.asVarargsCollector(int[].class);
            methodHandle.invoke(this, "张三", 23, 2, 3, 4, 5, 6);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * 可变参数  固定数量转换。
     */
    public void asCollector() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, String.class, int.class, int[].class);
        try {
            MethodHandle methodHandle = lookup.findVirtual(CreateMethodType.class, "normalMethod", methodType);
            methodHandle = methodHandle.asCollector(int[].class, 2);
            methodHandle.invoke(this, "张三自", 12, 23, 24);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * 长度可变的参数转换成数组类型的参数。
     */
    public void asSpreader() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, String.class, int.class, int.class, int.class);
        try {
            MethodHandle methodHandle = lookup.findVirtual(CreateMethodType.class, "normalMethod", methodType);
            methodHandle = methodHandle.asSpreader(int[].class, 3);
            methodHandle.invoke(this, "hello", new int[] {2, 3, 4});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void asFixedArrayInvoke(String str, int... arrays) {
        System.out.println("我有可变数组:" + str + " " + Arrays.toString(arrays));
    }

    public void asFixedArray() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, String.class, int[].class);
        try {
            MethodHandle methodHandle = lookup.findVirtual(CreateMethodType.class, "asFixedArrayInvoke", methodType);
            methodHandle = methodHandle.asFixedArity();
            methodHandle.invoke(this, "wxsswewe", new int[] {2, 3, 4});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateMethodType();
        generateGenericMethodTypes();
        generateMethodTypesFromDescriptor();
        try {
            invokeExact();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        CreateMethodType createMethodType = new CreateMethodType();
        createMethodType.asVarargsCollector();
        createMethodType.asCollector();
        createMethodType.asSpreader();
        createMethodType.asFixedArray();
    }

}
