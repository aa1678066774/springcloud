package com.tww.io;

import java.io.*;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-16 15:05
 */
public class Test1 {

    public static void copy(String src, String dst) {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
