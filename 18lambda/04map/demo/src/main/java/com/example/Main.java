package com.example;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        /*
         * 完整的写法
         */
        stream.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * n;
            }
        }).forEach(System.out::println);

        /*
         * 使用函数式 @FunctionalInterface，可以只写函数入参，返回值
         */
        stream = Stream.of(1, 2, 3, 4, 5);
        stream.map((n) -> {
            return n * n;
        }).forEach(System.out::println);

        /*
         * 精简版
         */

        stream = Stream.of(1, 2, 3, 4, 5);
        stream.map((n) -> n * n).forEach(System.out::println);

        /*
         * 直接传入函数
         */
        stream = Stream.of(1, 2, 3, 4, 5);
        stream.map(Main::square).forEach(System.out::println); // 传入参数和 apply方法参数一致的函数
                                                               // ——也就是函数式编程

        /*********************************************************************************************************/

        List.of("Apple", "Orange", "Banana").stream().map(String::trim); // trim()，实际有一个参数 this
        List.of("Apple", "Orange", "Banana").stream().map(n -> {
            return n.trim();
        });
        List.of("Apple", "Orange", "Banana").stream().map(n -> n.trim());

        List.of("Apple", "Orange", "Banana").stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.trim();
            }

        });
        List.of("Apple", "Orange", "Banana").stream().map(String::trim).map(String::toUpperCase)
                .forEach(System.out::println);
    }

    static Integer square(Integer n) {
        return n * n;
    }
}