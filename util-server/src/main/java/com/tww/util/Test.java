package com.tww.util;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2020-01-19 17:11
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //System.out.println(new String("123%456".getBytes(Charset.forName("UTF-8")),"ISO8859-1").replace("%","abc"));
//        printName("D:\\test");
//        method();

//        System.out.println(Arrays.asList("A","B").stream().filter(it->it.equals("A")).collect(Collectors.toList()));

//        System.out.println(100>>>2);

//        Date date=new Date();
//
//        Calendar calendar1=Calendar.getInstance();
//        Date date1= new Date();
//        calendar1.setTime(date1);
//        calendar1.set(Calendar.YEAR,2019);
//        date1=calendar1.getTime();
//
//        Calendar calendar2=Calendar.getInstance();
//        Date date2=new Date();
//        calendar2.setTime(date2);
//        calendar2.set(Calendar.YEAR,2021);
//        date2=calendar2.getTime();
//
//
//        System.out.println(date.before(date1)||date.after(date2));
//        if(date.before(date)){
//            System.out.println(date.before(date));
//        }

//        List<Integer> list=Arrays.asList(1,2,3,4,5,6);
//        for (Integer i:list){
//            if(i==5){
//                continue;
//            }
//            System.out.println(i);
//        }

//        Long a=10L;
//        System.out.println(a.toString());


        IntStream.range(1,2).forEach(i->{
            System.out.println(i);
        });
    }


    public static void method(){
        try {
            System.out.println("123");
            System.out.println(1/0);
            return;
        }finally {
            System.out.println("456");
        }
    }


    public static void printName(String path){
        File file=new File(path);
        if(file.isDirectory()){
            File[] files=file.listFiles();
            Arrays.stream(files).forEach(item->printName(item.getPath()));
        }
        System.out.println(file.getName());
    }
}
