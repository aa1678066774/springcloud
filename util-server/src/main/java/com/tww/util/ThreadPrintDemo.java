package com.tww.util;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-11-11 16:35
 */
public class ThreadPrintDemo {

    static volatile int num = 0;

    static volatile boolean flag = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (; 100 > num; ) {
                if (!flag && (num == 0 || ++num % 2 == 0)) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }

                    System.out.println(Thread.currentThread().getName()+":"+num);
                    flag = true;
                }
            }
        }
        );

        Thread t2 = new Thread(() -> {
            for (; 100 > num; ) {
                if (flag && (++num % 2 != 0)) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }

                    System.out.println(Thread.currentThread().getName()+":"+num);
                    flag = false;
                }
            }
        }
        );

        t1.start();
        t2.start();

    }
}
