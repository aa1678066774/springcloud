package com.tww.annocation;

import java.beans.Transient;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-10 10:12
 */
@TestAnnotation(id = 1,msg = "123")
public class Test {

    @Deprecated
    int a;


    @Transient(false)
    public void testMethod(){}


    @SuppressWarnings("deprecation")
    public void test1(){
    }


    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        //通过 Class 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解
        System.out.println(Test.class.isAnnotationPresent(TestAnnotation.class));

        //获取类注解
        Stream.of(Test.class.getAnnotations()).forEach(item->{
            System.out.println(item.annotationType().getSimpleName());
        });


        Field a = Test.class.getDeclaredField("a");
        a.setAccessible(true);
        //获取一个成员变量上的注解
        Deprecated deprecated = a.getAnnotation(Deprecated.class);

        if ( deprecated != null ) {
            System.out.println("has deprecated");
        }
        //@Retention 不在运行时没办法获取
        Method test1 = Test.class.getDeclaredMethod("test1");

        if ( test1 != null ) {
            // 获取方法中的注解
            Annotation[] ans = test1.getAnnotations();
            for( int i = 0;i < ans.length;i++) {
                System.out.println("method test1 annotation:"+ans[i].annotationType().getSimpleName());
            }
        }

    }

}
