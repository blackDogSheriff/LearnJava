package com.example;
/*
 * Stream有两种操作：
 * - 转换操作：map(), filter()；
 * - 聚合操作：reduce()；
 * - 转换操作是不会触发任何计算的！！！
 */

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
         * 转换操作只进行规则转换，没有进行任何实际计算
         */
        Stream<Long> stream = Stream.generate(new NatualSupplier());
        Stream<Long> stream2 = stream.map(n -> n * n);
        Stream<Long> stream3 = stream2.map(n -> n - 1);
        System.out.println(stream3);

        /*
         * 聚合操作会立刻触发计算，输出所有元素，一次纳入计算，并输出最终结果；
         */

        Stream<Long> stream4 = stream3.limit(20);
        stream4.reduce(0L, (acc, n) -> acc + n);

        outputToList();
        outputToArray();
        outputGroupBy();
    }

    public static void outputToList() {
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", " ", "Orage");
        List<String> list = stream.filter(s -> s != null && !s.isBlank()).collect(Collectors.toList());
        System.out.println(list);

    }

    public static void outputToArray() {
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", " ", "Orage");
        String[] array = stream.filter(s -> s != null && !s.isBlank()).toArray(String[]::new);
        System.out.println(array);
    }

    /*
     * String流转Map
     */
    public static void outputToMap() {
        Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream
                .collect(Collectors.toMap(s -> s.substring(0, s.indexOf(":")), s -> s.substring(s.indexOf(":") + 1)));
        System.out.println(map);
    }

    public static void outputGroupBy() {
        List<String> list = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        Map<String, List<String>> groups = list.stream().collect(Collectors.groupingBy(s->s.substring(0, 1), Collectors.toList()));
        System.out.println(groups);
    }

}

class NatualSupplier implements Supplier<Long> {
    Long n = 0L;

    @Override
    public Long get() {
        return n++;
    }
}