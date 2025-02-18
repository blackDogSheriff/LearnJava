package com.example.func;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        testFunctionalInterface();
        test();
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }

    static void test() {
        String[] arr = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        // 方法五：cmp签名和compare签名一致，直接传入静态方法：
        Arrays.sort(arr, Main::cmp);

        // 方法六：传递非静态方法：实例方法第一个参数为this，因此compareTo虽然只有一个String，但是等价于(String, String)
        Arrays.sort(arr, String::compareTo);

    }

    /*
     * 函数式
     */
    static void testFunctionalInterface() {
        String[] arr = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        // 方法一：直接传入接口实现类
        Arrays.sort(arr, new MyComparator());

        // 方法二：使用内部匿名类
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // 方法三：使用lambda表达式（1. @FunctionalInterface， 2. 只有一个抽象方法）；
        Arrays.sort(arr, (a, b) -> {
            return a.compareTo(b);
        });

        // 方法四：如果覆写函数中只有一行return，可以继续简化
        Arrays.sort(arr, (a, b) -> a.compareTo(b));
    }

}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}