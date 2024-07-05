package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        sortStream();
        uniqStream();
        pickStream();
        mergeStream();
        flatMapStream();
        parallelStream();
    }

    /*
     * 排序：
     * - 要求每个实例重都有 Comparable 方法
     */
    public static void sortStream() {
        List<String> ls = List.of("Orage", "Apple", "Banana", "Pineapple")
                .stream()
                .sorted() // 默认排序
                .sorted(new Comparator<String>() { // 传入对象
                    @Override
                    public int compare(String o1, String o2) {
                        return 0;
                    }
                }) // 默认排序
                .sorted(String::compareToIgnoreCase) // 函数式
                .sorted((s1, s2) -> s1.compareTo(s2)) // 函数式简写
                .collect(Collectors.toList());
        System.out.println(ls);
    }

    public static void uniqStream() {
        List<String> ls = List.of("A", "B", "C", "D", "S", "F", "T", "U", "A", "V", "W", "X", "Y", "Z")
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(ls);
    }

    public static void pickStream() {
        List<String> ls = List.of("A", "B", "C", "D", "S", "F", "T", "U", "A", "V", "W", "X", "Y", "Z")
                .stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(ls);
    }

    public static void mergeStream() {
        Stream<Integer> s1 = List.of(1, 2, 3).stream();
        Stream<Integer> s2 = List.of(4, 5, 6).stream();

        /*
         * 将两个流合并成一个流
         */
        Stream<Integer> s3 = Stream.concat(s1, s2);
        s3.forEach(System.out::print);
        System.out.println();
    }

    public static void flatMapStream() {
        Stream<List<Integer>> s1 = List.of(List.of(1, 2, 3), List.of(4, 5, 6)).stream();
        // 将嵌套的流展开成单个流
        Stream<Integer> s2 = s1.flatMap(list -> list.stream());
        s2.forEach(System.out::print);
        System.out.println();
    }

    public static void parallelStream() {
        List<String> ls = List.of("A", "B", "C", "D", "S", "F", "T", "U", "A", "V", "W", "X", "Y", "Z");
        Stream<String> s = ls.stream();
        String[] result = s.parallel() // 编程并行stream
                .distinct()
                .sorted()
                .toArray(String[]::new);
        // 打印result
        for (String s1 : result) {
            System.out.print(s1);
        }
    }
}