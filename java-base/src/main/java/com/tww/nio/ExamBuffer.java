package com.tww.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-10 13:44
 */
public class ExamBuffer {
    public static void main(String[] args) throws IOException {
        //为48个字符分配空间的ByteBuffer
//        ByteBuffer byteBufferuf = ByteBuffer.allocate(48);

        //为1024个字符分配空间的CharBuffer
//        CharBuffer charBuffer = CharBuffer.allocate(1024);
//
//        charBuffer.put('a');
//        charBuffer.put('c');
//        charBuffer.put('b');
//        charBuffer.put('d');
//
//        while(charBuffer.hasRemaining()){
//            System.out.println(charBuffer.get());
//        }


//        RandomAccessFile fromFile = new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\nio\\a.txt", "rw");
//        FileChannel fromChannel = fromFile.getChannel();
//
//        RandomAccessFile toFile = new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\nio\\b.txt", "rw");
//        FileChannel toChannel = toFile.getChannel();
//
//        long position = 0;
//        long count = fromChannel.size();
//
//        toChannel.transferFrom(fromChannel,toChannel.size(),count);


        Selector selector = Selector.open();

        //FileChannel无法切换到非阻塞模式
        SocketChannel channel=null;
        //将SocketChannel切换为非阻塞模式
        channel.configureBlocking(false);
        //将SocketChannel注册到selector
        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        SelectionKey key = channel.register(selector, interestSet);
        int interests = key.interestOps();
        System.out.println(interests&SelectionKey.OP_READ);


    }
}
