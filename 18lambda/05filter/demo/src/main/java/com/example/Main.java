package com.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(null)


        IntStream.range(1, 10).filter(n -> n % 2 != 0).forEach(System.out::println);

        Stream.generate(new LocalDateSupplier()).limit(31)
                .filter(ldt -> ldt.getDayOfWeek() == DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);
    }

    public static void testFilter() {
        // 方式一：直接实现对象
        IntStream.range(1, 10).filter(new MyPredicate()).forEach(n -> System.out.println(n));
        // 方式二：匿名内部类实现对象
        IntStream.range(1, 10).filter(new IntPredicate() {
            @Override
            public boolean test(int n) {
                return n % 2 != 0;
            }
        }).forEach(n -> System.out.println(n));
        // 方式三：lambda表达式，@FunctionalInterface，可以直接写参数 + 函数体
        IntStream.range(1, 10).filter((n) -> {
            return n % 2 != 0;
        }).forEach(n -> System.out.println(n));

        // 方法四：lambda表达式：如果return只有一行，可以直接写return的内容
        IntStream.range(1, 10).filter(n -> n % 2 != 0).forEach(n -> System.out.println(n));

        // 传入静态函数
        IntStream.range(1, 10).filter(Main::test).forEach(n -> System.out.println(n));
        // 传入实例函数
        // 使用构造函数
    }

    public static boolean test(int n) {
        return n % 2 != 0;
    }

    public void testGenerator() {
        // 方式一：直接实现接口
        Stream.generate(new MySupplier()).limit(31)
                .filter(ldt -> ldt.getDayOfWeek() == DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);

        // 方式二：使用匿名内部类实现接口
        Stream.generate(new Supplier<LocalDate>() {
            LocalDate start = LocalDate.of(2020, 1, 1);
            int n = -1;

            @Override
            public LocalDate get() {
                return start.plusDays(++n);
            }
        }).limit(100).filter(ldt -> ldt.getDayOfWeek() == DayOfWeek.SATURDAY || ldt.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);

        // 方式三：lambda表达式，由于需要借助局部对象，暂时不知道怎么写lambda表达式
        
    }
}

class MyPredicate implements IntPredicate {
    @Override
    public boolean test(int n) {
        return n % 2 != 0;
    }
}

class MySupplier implements Supplier<LocalDate> {
    LocalDate start = LocalDate.of(2020, 1, 1);
    int n = -1;

    @Override
    public LocalDate get() {
        return start.plusDays(++n);
    }
}

class LocalDateSupplier implements Supplier<LocalDate> {
    private final LocalDate start = LocalDate.of(2020, 1, 1);
    int n = -1;

    @Override
    public LocalDate get() {
        return start.plusDays(++n);
    }
}
