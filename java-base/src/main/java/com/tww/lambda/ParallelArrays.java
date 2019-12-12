package com.tww.lambda;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-11 15:06
 */
public class ParallelArrays {
    public static void main(String[] args) throws InterruptedException {
//        long[] arrayOfLong = new long [ 20000 ];
//
//        Arrays.parallelSetAll( arrayOfLong,
//                index -> ThreadLocalRandom.current().nextLong( 1000000 ) );
//        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
//                i -> System.out.print( i + " " ) );
//        System.out.println();
//
//        Arrays.parallelSort( arrayOfLong );
//        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
//                i -> System.out.print( i + " " ) );
//        System.out.println();


//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        List<Calendar> list = new Vector<>();
//        for (int i = 0; i < 20; i++) {
//            Calendar startDay = new GregorianCalendar();
//            Calendar checkDay = new GregorianCalendar();
//            checkDay.setTime(startDay.getTime());//不污染入参
//            checkDay.add(checkDay.DATE,i);
//            list.add(checkDay);
//            checkDay = null;
//            startDay = null;
//        }
//
//
//        list.stream().forEach(day ->  System.out.print(sdf.format(day.getTime())+"\t"));
//        System.out.println("-----------------------");
//        list.parallelStream().forEach(day ->  {synchronized(sdf){System.out.print(sdf.format(day.getTime())+"\t");}});
//        System.out.println("-----------------------");


        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7,8,9,10,11,12};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        Queue<Integer> parallelStorage = new ConcurrentLinkedQueue<>();//Collections.synchronizedList(new ArrayList<>());
        listOfIntegers.parallelStream()
                // Don't do this! It uses a stateful lambda expression.
                .map(e -> {
                    parallelStorage.add(e);
                    return e;
                }).forEachOrdered(e -> System.out.print(e + " "));
        System.out.println();
        parallelStorage.stream().forEachOrdered(e -> System.out.print(e + " "));

        System.out.println();

    }
}
