package com.tww.util;

import com.alibaba.fastjson.JSON;
import com.sun.jmx.remote.internal.ArrayQueue;
import lombok.Data;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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
    public static void main(String[] args) throws IOException {
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


//        IntStream.range(1,2).forEach(i->{
//            System.out.println(i);
////        });
//        File file=new File("C:\\Users\\Administrator\\git\\root\\util-server\\aaa\\a.txt");
//        File file1=new File("C:\\Users\\Administrator\\git\\root\\util-server\\bbb\\b.txt");
////
////        if(!file1.exists()){
////            file1.getParentFile().mkdirs();
////        }
////        Files.copy(file.toPath(),file1.toPath());
//
//        Files.copy(file.toPath(),Files.createDirectory(Paths.get("\\bbb\\b.txt").toAbsolutePath().normalize()));

//        System.out.println(Arrays.toString("a.b".split("\\.")));
//
//
//        ExportMessageDto messageDto= JSON.parseObject("{\"status\": 1, \"project_id\": \"14\", \"busId\": \"2\"}", ExportMessageDto.class);
//        System.out.println(messageDto);

        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(simpleDateFormat.format(date));
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

@Data
class ExportMessageDto {

    private Long busId;

    private Long project_id;

    private Integer status;
}