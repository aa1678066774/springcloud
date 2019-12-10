package com.tww.nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: root
 * @description: 文件通道测试
 * @author: weiweiTang
 * @create: 2019-12-10 14:38
 */

//FileChannel无法设置为非阻塞模式。它始终以阻塞模式运行。
public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\nio\\a.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        FileInputStream inputStream= new FileInputStream("C:\\Users\\Administrator\\Desktop\\nio\\b.txt");
        FileChannel inChannel1=inputStream.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        while(inChannel1.read(buf)!=-1){
            buf.flip();

            while(buf.hasRemaining()) {
                System.out.print((char)buf.get());
            }
            buf.clear();
        }


    }
}
