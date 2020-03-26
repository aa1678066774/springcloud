package com.tww.util;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2020-01-17 17:56
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader("D:\\Documents\\WXWork\\1688853003882306\\Cache\\File\\2020-01\\1.log");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            List<String> list=new ArrayList<>();
            list.add("lastname");
            list.add("maritalstatus");
            list.add("mobile");
            list.add("birthday");
            list.add("sex");
            list.add("certificatenum");
            while ((str = bf.readLine()) != null) {
                System.out.println(str);
                str=str.replace("'","\"").replace("=","\":").replace(", ",", \"").replace("{","{\"");
                Map<String,Object> map=JSONObject.parseObject(str, HashMap.class);
                map.entrySet().stream().forEach(item->{
                    if(list.contains(item.getKey())){
                        System.out.print(item.getValue()+"\t");
                    }
                });
                System.out.println();
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
