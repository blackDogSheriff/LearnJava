package com.example;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        testMap();
        List.of("Apple", "Banana", "Pear")
                .stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    static Integer square(Integer n) {
        return n * n;
    }

    /*
     * 函数式的几种写法
     */
    public static void testMap() {
        // 写法一：直接实现类
        Stream.of(1, 2, 3, 4, 5).map(new MyIntFunction()).forEach(System.out::println);
        // 写法二：通过内部匿名类实现
        Stream.of(1, 2, 3, 4, 5).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * n;
            }
        }).forEach(System.out::println);

        // 写法三：函数式：FunctionalInterface，可以只写函数入参，方法体
        Stream.of(1, 2, 3, 4, 5).map((n) -> {
            return n * n;
        }).forEach(System.out::println);

        // 写法四：函数式：如果方法体只有一行return，那么可以直接写return的内容，省略{}和return
        Stream.of(1, 2, 3, 4, 5).map(n -> n * n).forEach(System.out::println);

        // 写法五：直接传入静态函数，静态函数不会默认传递this指针，参数需要和函数式对象中抽象方法保持一致
        Stream.of(1, 2, 3, 4, 5).map(MyIntFunction::staticFunc).forEach(System.out::println);

        // 写法六：直接传入实例函数，实例函数会默认传递this指针，参数需要考虑this指针
        Stream.of(1, 2, 3, 4, 5).map(Integer::doubleValue).forEach(System.out::println);

        // 写法七：使用构造方法
    }
}

class MyIntFunction implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer n) {
        return n * n;
    }

    public static Integer staticFunc(Integer n) {
        return n * n;
    }

}