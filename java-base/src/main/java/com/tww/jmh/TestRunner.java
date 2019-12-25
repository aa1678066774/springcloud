package com.tww.jmh;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-23 15:15
 */
public class TestRunner {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include("Test")
                .exclude("Pref")
                .warmupIterations(4)
                .measurementIterations(4)
                .forks(3)
                .build();
        new Runner(opt).run();
    }
}
