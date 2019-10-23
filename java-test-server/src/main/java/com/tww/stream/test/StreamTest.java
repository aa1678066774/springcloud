package com.tww.stream.test;

import com.tww.stream.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: root
 * @description: Stream测试类
 * @author: weiweiTang
 * @create: 2019-09-26 15:11
 */
public class StreamTest {

    public static void main(String[] args) {
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "A", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);


        list.stream()
                .filter(student -> student.getSex().equals("G"))
                .forEach(student -> System.out.println(student.toString()));

        System.out.println(list.stream()
                .filter(student -> student.getSex().equals("G")).count());


        /**
         * generator方法，返回一个无限长度的Stream,其元素由Supplier接口的提供。
         * 在Supplier是一个函数接口，只封装了一个get()方法，其用来返回任何泛型的值，该结果在不同的时间内，返回的可能相同也可能不相同，没有特殊的要求。
         */
        System.out.println(Arrays.toString(Stream.generate(Math::random).limit(20).toArray()));


        /*============================================= Intermediate   =========================================*/

        /**
         * concat
         * concat方法将两个Stream连接在一起，合成一个Stream。
         * 若两个输入的Stream都时排序的，则新Stream也是排序的；
         * 若输入的Stream中任何一个是并行的，则新的Stream也是并行的；
         * 若关闭新的Stream时，原两个输入的Stream都将执行关闭处理。
         */
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5))
                .forEach(integer -> System.out.print(integer + "  "));


        /**
         * distinct方法以达到去除掉原Stream中重复的元素，生成的新Stream中没有没有重复的元素。equals 比较
         *
         * 两个对象相等，hashcode一定相等
         *
         * 两个对象不等，hashcode不一定不等
         *
         * hashcode相等，两个对象不一定相等
         *
         * hashcode不等，两个对象一定不等
         *
         */
        list.stream()
                .distinct()
                .forEach(System.out::println);


        /**
         * filter方法对原Stream按照指定条件过滤，在新建的Stream中，只包含满足条件的元素，将不满足条件的元素过滤掉
         *
         */
        Stream.of(1, 2, 3, 4, 5)
                .filter(item -> item > 3)
                .forEach(System.out::println);

    }


}
