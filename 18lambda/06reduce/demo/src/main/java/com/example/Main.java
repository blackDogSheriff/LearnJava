package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(0, (acc, n) -> acc + n);
        int sum1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer acc, Integer n) {
                return acc + n;
            }
        });
        int sum2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(0, (acc, n) -> {
            return acc + n;
        });

        int s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(1, (acc, n) -> acc * n);
        System.out.println(s);

        testReduce();
    }

    public static void testReduce() {
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
}