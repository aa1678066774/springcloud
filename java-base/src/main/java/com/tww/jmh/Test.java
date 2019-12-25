package com.tww.jmh;

import com.tww.lambda.Person;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-23 15:12
 */
@State(Scope.Benchmark)
public class Test {

    List<Person> personList;

    List<Person> personList1;

//    @Setup
//    public void init() {
//        personList=new ArrayList<>();
//        Random random=new Random();
//        IntStream.range(0,10000000).forEach(i->{
//            personList.add(new Person("name"+i,random.nextInt(100),null));
//        });
//    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
    public void init() {
        personList=new ArrayList<>();
        IntStream.range(0,1000000).forEach(i->{
            personList.add(new Person());
        });
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
    public void init1() {
        personList1=new ArrayList<>(1000000);
        IntStream.range(0,1000000).forEach(i->{
            personList1.add(new Person());
        });
    }


//    @Benchmark
//    @BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
//    @Threads(100)
//    public void m() {
//        personList.forEach(it->{
//
//        });
//    }
//
//    @Benchmark
//    @BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
//    @Threads(100)
//    public void m1() {
//        personList.stream().forEach(it->{
//
//        });
//    }
//
//    @Benchmark
//    @BenchmarkMode({Mode.Throughput, Mode.SingleShotTime})
//    @Threads(100)
//    public void m2() {
//        personList.parallelStream().forEach(it->{
//
//        });
//    }
}
