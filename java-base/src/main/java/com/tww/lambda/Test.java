package com.tww.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-10 17:30
 */
public class Test {

    public static void main(String[] args) {
//        String[] words = new String[]{"Hello","World"};
//        System.out.println();
//        Map<String,Long> map=Arrays.stream(words).map(item->item.split("")).flatMap(Arrays::stream).collect(Collectors.groupingBy(s->s,Collectors.counting()));
//        map.entrySet().stream().forEach(System.out::println);
        test();
    }

    public static void test(){
        List<String> list=Arrays.asList("a","b");
        IntStream.range(0,list.size()).forEach(i->{
            System.out.println(list.get(i));
        });
    }
}
