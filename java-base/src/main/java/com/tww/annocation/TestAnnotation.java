package com.tww.annocation;

import java.lang.annotation.*;

/**
 * Retention 的英文意为保留期的意思。当 @Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间。
 * 它的取值如下：
 * RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
 * RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。注解默认使用这种方式。
 * RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。因此可以使用反射机制读取该注解的信息
 */
@Retention(RetentionPolicy.RUNTIME)

/**
 * 是能够将注解中的元素包含到 Javadoc 中去
 */
@Documented


/**
 * Target 是目标的意思，@Target 指定了注解运用的地方。
 *
 * 你可以这样理解，当一个注解被 @Target 注解时，这个注解就被限定了运用的场景。
 *
 * @Target 有下面的取值
 *
 * ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
 *
 * ElementType.CONSTRUCTOR 可以给构造方法进行注解
 *
 * ElementType.FIELD 可以给属性进行注解
 *
 * ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
 *
 * ElementType.METHOD 可以给方法进行注解
 *
 * ElementType.PACKAGE 可以给一个包进行注解
 *
 * ElementType.PARAMETER 可以给一个方法内的参数进行注解
 *
 * ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
 */
@Target(ElementType.TYPE)

/**
 * Inherited 是继承的意思，但是它并不是说注解本身可以继承，而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，
 * 那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解。
 */
@Inherited


/**
 *Repeatable 自然是可重复的意思。@Repeatable 是 Java 1.8 才加进来的，所以算是一个新的特性。
 * 什么样的注解会多次应用呢？通常是注解的值可以同时取多个。
 */
@Repeatable(TestAnnotations.class)
public @interface TestAnnotation {

    /**
     * 返回值类型只能是8 种基本数据类型、Class、String、enum及它们的数组
     * 注解中属性可以有默认值，默认值需要用 default 关键值指定。
     * 如果一个注解内仅仅只有一个名字为 value 的属性时，应用这个注解时可以直接接属性值填写到括号内
     * @return
     */
    int id() default 0;

    String msg();


    /**
     * @Deprecated
     * 这个元素是用来标记过时的元素，想必大家在日常开发中经常碰到。编译器在编译阶段遇到这个注解时会发出提醒警告，告诉开发者正在调用一个过时的元素比如过时的方法、过时的类、过时的成员变量。
     *
     * @Override
     * 这个大家应该很熟悉了，提示子类要复写父类中被 @Override 修饰的方法
     *
     * @SuppressWarnings
     * 阻止警告的意思。之前说过调用被 @Deprecated 注解的方法后，编译器会警告提醒，而有时候开发者会忽略这种警告，他们可以在调用的地方通过 @SuppressWarnings 达到目的。
     *
     * @SafeVarargs
     * 参数安全类型注解。它的目的是提醒开发者不要用参数做一些不安全的操作,它的存在会阻止编译器产生 unchecked 这样的警告。它是在 Java 1.7 的版本中加入的。
     *
     * @FunctionalInterface
     * 函数式接口注解，这个是 Java 1.8 版本引入的新特性。函数式编程很火，所以 Java 8 也及时添加了这个特性。
     * 函数式接口 (Functional Interface) 就是一个具有一个方法的普通接口。
     * 我们进行线程开发中常用的 Runnable 就是一个典型的函数式接口，源码可以看到它就被 @FunctionalInterface 注解。
     */
}
