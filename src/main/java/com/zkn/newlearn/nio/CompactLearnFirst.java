package com.zkn.newlearn.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by zkn on 2017/3/15.
 */
public class CompactLearnFirst {

    @Test
    public void compact01(){

        ByteBuffer buffer = ByteBuffer.wrap("abcdefghijklmnopqrstuvwxyz".getBytes());
        System.out.println(buffer);
        for(int i=0;i<5;i++){
            System.out.println(String.valueOf(buffer.get()));
        }
    }

    /**
     * 将缓冲区的当前位置和界限之间的字节（如果有）复制到缓冲区的开始处。
     * 即将索引 p = position() 处的字节复制到索引 0 处，将索引 p + 1 处的字节复制到索引 1 处，
     * 依此类推，直到将索引 limit() - 1 处的字节复制到索引 n = limit() - 1 - p 处。
     * 然后将缓冲区的位置设置为 n+1，并将其界限设置为其容量。如果已定义了标记，则丢弃它。
     * 将缓冲区的位置设置为复制的字节数，而不是零，以便调用此方法后可以紧接着调用另一个相对 put 方法。
     */
    @Test
    public void compact02(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        CharBuffer charBuffer = CharBuffer.allocate(100);
        for(int i=0;i<chars.length;i++){
            charBuffer.put(chars[i]);
        }
        System.out.println("position:"+charBuffer.position()+" limit:"+charBuffer.limit()+" cap:"+charBuffer.capacity());
        charBuffer.flip();
        for(int i=0;i<5;i++){
            System.out.println(String.valueOf(charBuffer.get()));
        }
        System.out.println("第一次Compact前：position:"+charBuffer.position()+" limit:"+charBuffer.limit()+" cap:"+charBuffer.capacity());
        charBuffer.compact();
        //第一次压缩后，position的位置为：n+1 而n的值为：limit() - 1 - p
        System.out.println("第一次Compact后：position:"+charBuffer.position()+" limit:"+charBuffer.limit()+" cap:"+charBuffer.capacity());
        //charBuffer.flip();
        for(int i=0;i<5;i++){
            System.out.println(String.valueOf(charBuffer.get()));
        }
        System.out.println("第二次Compact前：position:"+charBuffer.position()+" limit:"+charBuffer.limit()+" cap:"+charBuffer.capacity());
        charBuffer.compact();
        System.out.println("第二次Compact后 position:"+charBuffer.position()+" limit:"+charBuffer.limit()+" cap:"+charBuffer.capacity());
        //charBuffer.flip();
        for(int i=0;i<5;i++){
            System.out.println(String.valueOf(charBuffer.get()));
        }
    }
}
