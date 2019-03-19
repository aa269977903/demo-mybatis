package com.cest.util;

import java.util.stream.IntStream;

/**
 * Created by cestlavie on 2019/2/25.
 */
public class TempIDUtils {

    private static byte[] lock = new byte[0];

    private final static long w = 10000000;

    public static String createId(){
        long r = 0;
        synchronized (lock) {
            r = (long)((Math.random() + 1) * w);
        }
        return System.currentTimeMillis() + String.valueOf(r).substring(1);
    }

    public static void main(String[] args) {
        String id = TempIDUtils.createId();
        System.out.println(id);

        int age = (int) (Math.random() * 100 + 1);
        System.out.println(age);

            IntStream.iterate(0 , k -> {
            return k;
        }).limit(33).forEach(System.out::println);

    }
}
