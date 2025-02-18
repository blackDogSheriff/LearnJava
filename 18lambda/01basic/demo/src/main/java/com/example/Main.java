package com.example;

import java.util.Arrays;
import java.util.Comparator;
/*
 * @FunctionalInterface
 * - 只定义一个抽象方法的接口
 */

public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] arr = { "a", "b", "c" };
        System.out.println(arr.toString());

        // 方式一：直接实现Comparator
        Arrays.sort(arr, new MyComparator());
        // 方式二：使用匿名内部类实现
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        // 方式三：Comparator只定义了一个抽象接口，并且有@FunctionalInterface注解，因此可以只传递函数体；参数类型可以省略
        Arrays.sort(arr, (s1, s2) -> {
            return s1.compareTo(s2);
        });
        //方式四：如果覆写的接口中只有一行return，也可以省略函数体的 {} 和 return

        Arrays.sort(arr, (s1, s2)-> s1.compareTo(s2));

    }

}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }

}
