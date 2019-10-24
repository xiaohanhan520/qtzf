package com.xh.utils;

import java.util.Random;
import java.util.UUID;

public class Md5Util {

    private static final String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    private static final String num = "1234567890";



    public static String getSale(){
        StringBuilder stringBuilder = new StringBuilder(6);
        for (int i = 0; i < 6; i++){
            char c = str.charAt(new Random().nextInt(str.length()));
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }


    public static String getUid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


    public static String getNum(){
        StringBuilder stringBuilder = new StringBuilder(6);
        for (int i = 0; i < 6; i++){
            char c = num.charAt(new Random().nextInt(num.length()));
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
