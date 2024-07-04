package com.example.createStream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        createStream();
    }

    public static void createStream() {
        /*
         * 将数组变成stream
         */
        Stream<String> stream = Arrays.stream(new String[] { "a", "b", "c" });
        // Stream.of等价于 Arrays.stream；
        Stream<String> stream2 = Stream.of("a", "b", "c");
        stream.forEach(System.out::println);

        /*
         * 对于Collection（List，Set，Queue）等，直接调用stream()获得stream
         */
        Stream<String> stream1 = List.of("X", "Y", "Z").stream();
        stream1.forEach(System.out::println);

        /*
         * 通过Supplier来生成自然数
         * - Supplier每次调用Supplier.get方法来不断产生下一个元素（保存的是算法）
         */
        Stream<Integer> stream3 = Stream.generate(new NatualSupplier());
        stream3.limit(20).forEach(System.out::println);

        /*
         * 通过api提供的接口，直接获取Stream
         */

        try (Stream<String> lines = Files.lines(Paths.get("/path/to/file.txt"))) {
        } catch (Exception e) {
        }

        /*
         * 通过Pattern.splitAsStream来获取Stream
         */
        Pattern p = Pattern.compile("\\s+");
        Stream<String> s = p.splitAsStream("The quick brown fox jumps over the lazy dog");
        s.forEach(System.out::println);

        /*
         * 基本类型；由于泛型不支持基本类型，因此不能创建基本类型的引用，只能用引用类型(Integer)来创建
         * 但是这样会频繁装箱拆箱，为了提高效率java标准库提供了IntStream、LongStream、DoubleStream等
         */

        IntStream isStream = Arrays.stream(new int[] { 1, 2, 3, 4, 5 });
        LongStream lsStream = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);

        /*
         * test
         */
        LongStream fib = LongStream.generate(new FibSupplier());
        fib.limit(100).forEach(System.out::println);

    }
}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;

    @Override
    public Integer get() {
        return n++;
    }
}

class FibSupplier implements LongSupplier {
    private long n = 0;

    @Override
    public long getAsLong() {
        return 0;
    }
}