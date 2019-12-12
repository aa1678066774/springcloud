package com.tww.lambda;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-11 14:49
 */
public class RemoveIfTest {
    public static void main(String[] args) throws ScriptException {
//        Collection<Person> collection = new ArrayList();
//        collection.add(new Person("张三", 22, "男"));
//        collection.add(new Person("李四", 19, "女"));
//        collection.add(new Person("王五", 34, "男"));
//        collection.add(new Person("赵六", 30, "男"));
//        collection.add(new Person("田七", 25, "女"));
//        collection.parallelStream().sorted().collect(Collectors.toList());

//过滤30岁以上的求职者
//        Iterator<Person> iterator = collection.iterator();
//        while (iterator.hasNext()) {
//            Person person = iterator.next();
//            if (person.getAge() >= 30)
//                iterator.remove();
//        }

//        collection.removeIf(it->it.getAge()>30);
//        System.out.println(collection.toString());//查看结果
//
//
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName( "JavaScript" );
//
//        System.out.println( engine.getClass().getName() );
//        System.out.println( "Result:" + engine.eval( "var i=[1,2,3];" ) );

        List<Person> personList=new ArrayList<>(1000000);
        Random random=new Random();
        IntStream.range(0,1000000).forEach(i->{
            personList.add(new Person("name"+i,random.nextInt(100),null));
        });
        long start=System.currentTimeMillis();
        personList.stream().forEach(it->{

        });
        long end=System.currentTimeMillis();
        System.out.println(end-start);

        long start1=System.currentTimeMillis();
        personList.forEach(it->{

        });
        long end1=System.currentTimeMillis();
        System.out.println(end1-start1);

        long start2=System.currentTimeMillis();
        personList.parallelStream().forEach(it->{

        });
        long end2=System.currentTimeMillis();
        System.out.println(end2-start2);

//        //实例化arrayList
//        List<Integer> arrayList = new ArrayList<Integer>();
//        //实例化linkList
//        List<Integer> linkList = new LinkedList<Integer>();
//
//        //插入10万条数据
//        for (int i = 0; i < 100000; i++) {
//            arrayList.add(i);
//            linkList.add(i);
//        }
//
//        int array = 0;
//        //用for循环arrayList
//        int size=arrayList.size();
//        long arrayForStartTime = System.currentTimeMillis();
//
//        for (int i = 0; i < size; i++) {
//            array = arrayList.get(i);
//        }
//        long arrayForEndTime = System.currentTimeMillis();
//        System.out.println("用for循环arrayList 10万次花费时间：" + (arrayForEndTime - arrayForStartTime) + "毫秒");
//
//        //用foreach循环arrayList
//        long arrayForeachStartTime = System.currentTimeMillis();
//        for(Integer in : arrayList){
//            array = in;
//        }
//        long arrayForeachEndTime = System.currentTimeMillis();
//        System.out.println("用foreach循环arrayList 10万次花费时间：" + (arrayForeachEndTime - arrayForeachStartTime ) + "毫秒");
//
//        //用for循环linkList
//        long linkForStartTime = System.currentTimeMillis();
//        int link = 0;
//        for (int i = 0; i < linkList.size(); i++) {
//            link = linkList.get(i);
//        }
//        long linkForEndTime = System.currentTimeMillis();
//        System.out.println("用for循环linkList 10万次花费时间：" + (linkForEndTime - linkForStartTime) + "毫秒");
//
//        //用froeach循环linkList
//        long linkForeachStartTime = System.currentTimeMillis();
//        for(Integer in : linkList){
//            link = in;
//        }
//        long linkForeachEndTime = System.currentTimeMillis();
//        System.out.println("用foreach循环linkList 10万次花费时间：" + (linkForeachEndTime - linkForeachStartTime ) + "毫秒");


    }
}
