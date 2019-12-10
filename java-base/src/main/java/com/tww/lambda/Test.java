package com.tww.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-10 17:30
 */
public class Test {

    public static void main(String[] args) {
        String[] words = new String[]{"Hello","World"};
        System.out.println();
        Map<String,Long> map=Arrays.stream(words).map(item->item.split("")).flatMap(Arrays::stream).collect(Collectors.groupingBy(s->s,Collectors.counting()));
        map.entrySet().stream().forEach(System.out::println);
    }
}
