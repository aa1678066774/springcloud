package com.tww;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-27 16:04
 */
public class Test {
    public static void main(String[] args) {
//        for(int i=1000;i<9999;i++){
//            for (int j=1;j<10;j++){
//                int a=(i/1000)%10;
//                int b=(i/100)%10;
//                int c=(i/10)%10;
//                int d=i%10;
//                int m=d*1000+c*100+b*10+a;
////                System.out.println(i*j);
////                System.out.println(m);
//                if(i*j==m&&a!=j&&b!=j&&c!=j&&d!=j&&a!=b&&a!=c&&a!=d&&b!=c&&c!=d){
//                    System.out.println(i+"*"+j+"="+m);
//                }
//            }
//        }
        fizzBuzz(1);
    }


    public static List<String> fizzBuzz(int n) {
        List<String> list=new ArrayList<>(n);
        IntStream.rangeClosed(1,n).forEach(i->{
            if(i%15==0){
                list.add("FizzBuzz");
            }else if(i%5==0){
                list.add("Buzz");
            }else if(i%3==0){
                list.add("Fizz");
            }else{
                list.add(i+"");
            }

        });
        System.out.println(list);
        return list;
    }


}
