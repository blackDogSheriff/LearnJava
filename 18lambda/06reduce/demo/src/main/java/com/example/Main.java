package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        testReduce();
        // testReduce1();
    }

    public static void testReduce1() {
        List<String> props = List.of("profile=native", "debug=true", "longging=warn", "interval=50");
        Map<String, String> map = props.stream().map(kv -> {
            String[] ss = kv.split("\\=", 2);
            return Map.of(ss[0], ss[1]);
        }).reduce(new HashMap<String, String>(), (m, kv) -> {
            m.putAll(kv);
            return m;
        });

        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }

    public static void testReduce() {
        // 方式一：实现对象
        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(1, new MyBinaryOperator()));
        // 方式二：使用匿名内部类实现对象
        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(1, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i1, Integer i2) {
                return i1 + i2;
            }
        }));

        // 方式三：使用Lambda表达式
        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(1, (i1, i2) -> {
            return i1 + i2;
        }));

        // 方式四：简写lambda表达式
        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(1, (i1, i2) -> i1 + i2));

        //方式五：直接传入静态方法
        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(1, Main::sum));
        //方式六：使用实例方法（如果参数包含实例自己，通过this传递）

    }

    public static Integer sum(Integer i1, Integer i2) {
        return i1 + i2;
    }

    /*
     * 不传入初值：使用Optional避免函数式编程中处理流返回的空指针异常
     */
    public static void testOptional() {
        Optional<Integer> i = Stream.of(1, 2, 3, 4, 5).reduce(new MyBinaryOperator());
        i.ifPresent((a) -> System.out.println(a));

        //空值情况测试
        Optional<Integer> i3 = Optional.empty();
        i3.ifPresent((a) -> System.out.println(a));
    }
}

class MyBinaryOperator implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer i1, Integer i2) {
        return i1 + i2;
    }
}