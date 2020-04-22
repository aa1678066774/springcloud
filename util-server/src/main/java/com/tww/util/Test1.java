package com.tww.util;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.jodah.expiringmap.ExpiringMap;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import net.jodah.expiringmap.*;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2020-01-17 17:56
 */
public class Test1 {
    public static void main(String[] args) {

        Cache<String, String> cache = CacheBuilder.newBuilder().build();

        ExpiringMap<String, String> map = ExpiringMap.create();
        map.put("A","1",10,TimeUnit.SECONDS);

        System.out.println(map.toString());


        List<Version> number = new ArrayList<>();
        Version v1=new Version("A",1);
        Version v2=new Version("A",3);
        Version v3=new Version("A",2);
        Version v4=new Version("A",5);
        Version v5=new Version("A",4);
        Version v6=new Version("B",2);
        Version v7=new Version("B",1);
        Version v8=new Version("C",0);
        Collections.addAll(number, v1,v2,v3,v4,v5,v6,v7,v8);
//// 筛选不重复的
////        List<Version> unrepeated = number.stream()
////                .filter(t1 -> number.stream().filter(t2 -> (t1.getName().equals(t2.getName())&&t1.getVer()<t2.getVer())).count() <= 1).collect(Collectors.toList());
////        System.out.println(unrepeated);
        List<Version> barList = Lists.newArrayList();
        number.stream().collect(Collectors.groupingBy(Version::getName,Collectors.toList())).forEach((name,list)->barList.add(list.stream().max(Comparator.comparingInt(Version ::getVer)).get()));
        System.out.println(barList);


//        String a="data/asd";
//        System.out.println(a.startsWith("/"));
//        ArrayList<String> arrayList = new ArrayList<>();
//        try {
//            FileReader fr = new FileReader("D:\\Documents\\WXWork\\1688853003882306\\Cache\\File\\2020-01\\1.log");
//            BufferedReader bf = new BufferedReader(fr);
//            String str;
//            // 按行读取字符串
//            List<String> list=new ArrayList<>();
//            list.add("lastname");
//            list.add("maritalstatus");
//            list.add("mobile");
//            list.add("birthday");
//            list.add("sex");
//            list.add("certificatenum");
//            while ((str = bf.readLine()) != null) {
//                System.out.println(str);
//                str=str.replace("'","\"").replace("=","\":").replace(", ",", \"").replace("{","{\"");
//                Map<String,Object> map=JSONObject.parseObject(str, HashMap.class);
//                map.entrySet().stream().forEach(item->{
//                    if(list.contains(item.getKey())){
//                        System.out.print(item.getValue()+"\t");
//                    }
//                });
//                System.out.println();
//            }
//            bf.close();
//            fr.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
@Data
@AllArgsConstructor
class Version{

    private String name;

    private Integer ver;
}
