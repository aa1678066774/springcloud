package com.tww.util;

import com.baomidou.dynamic.datasource.toolkit.CryptoUtils;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-05 11:08
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        String password = "root";

        String encodePassword = CryptoUtils.encrypt(password);
        System.out.println(encodePassword);
        System.out.println(CryptoUtils.decrypt(encodePassword));

        //自定义publicKey
        String[] arr = CryptoUtils.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + CryptoUtils.encrypt(arr[0], password));
        System.out.println("password:" + CryptoUtils.decrypt(arr[1],CryptoUtils.encrypt(arr[0], password)));
    }
}
