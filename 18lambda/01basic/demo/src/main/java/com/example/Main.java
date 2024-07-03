package com.example;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        String[] arr = { "a", "b", "e", "c" };
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));

        /*
         * Comparator只定义了单个抽象接口，@FunctionalInterface，
         */

        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array, (s1, s2)->{ //只需要写出方法体和参数
            return s1.compareTo(s2);
        });
    }
}