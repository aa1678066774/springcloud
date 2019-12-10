package com.tww.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-06 10:34
 */
public class LoopTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        for(int i=10000000;i>0;i--){
            list.add(i+"");
        }
        int size=list.size();
        long startTime=System.currentTimeMillis();
        System.out.println("lambda foreach start："+startTime);
        list.forEach(item->{
        });
        long endTime=System.currentTimeMillis();
        System.out.println("lambda foreach end："+endTime);
        System.out.println("lambda foreach speed:"+(endTime - startTime));



        startTime=System.currentTimeMillis();
        System.out.println("stream foreach start："+startTime);
        list.stream().forEach(item->{

        });
        endTime=System.currentTimeMillis();
        System.out.println("stream foreach end："+endTime);
        System.out.println("stream foreach speed:"+(endTime - startTime));


        startTime=System.currentTimeMillis();
        System.out.println("list foreach start："+startTime);
        for(String str:list){

        }
        endTime=System.currentTimeMillis();
        System.out.println("list foreach end："+endTime);
        System.out.println("list foreach speed:"+(endTime - startTime));
    }
}
