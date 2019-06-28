package com.tww.config;

/**
 * @program: root
 * @description: 线程异常
 * @author: weiweiTang
 * @create: 2019-06-20 16:04
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught    "+e);
    }
}
