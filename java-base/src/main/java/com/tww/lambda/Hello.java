package com.tww.lambda;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-17 16:58
 */
public class Hello {
    Runnable r1 = () -> { System.out.println(this); };
    Runnable r2 = () -> { System.out.println(toString()); };

    public String toString() {  return "Hello, world"; }

    public static void main(String... args) {
//        new Hello().r1.run();
//        new Hello().r2.run();

        FInterface in=(a,b)->a+b;
        System.out.println(in.sum(5,6));
    }


}