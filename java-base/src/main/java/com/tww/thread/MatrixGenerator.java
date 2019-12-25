package com.tww.thread;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-23 14:27
 */
public class MatrixGenerator {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generate(5,6)));
    }

    public static double[][] generate (int rows, int columns) {
        double[][] ret=new double[rows][columns];
        Random random=new Random();
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                ret[i][j]=random.nextDouble()*10;
            }
        }
        return ret;
    }
}
