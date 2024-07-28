package com.example.func;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };

        Arrays.sort(array, Main::cmp);
        Arrays.sort(array, String::compareTo);

        //最全写法
        Arrays.sort(arrays,new Comparator<T>() {
            @Override
            public int compareTo(T o1, T o2) {
                return o1.compareTo(o2);
            }
        } );

        /*
         * int compareTo(String anotherString)
         * 加上this指针，也是两个参数 a.compareTo(anotherString)
         */
        Arrays.sort(array, (a, b)->{ return a.compareTo(b);});

    }

    /*
     * 方法签名和 int compare(T o1, T o2); 一致，因此可以直接传入方法使用
     * 方法签名：返回值、参数类型
     * 注意static方法没有this指针默认传递
     */
    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}