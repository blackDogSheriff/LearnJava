package com.example.constructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Bob", "Alice", "Tim");
        List<Person> persons = new ArrayList<>();

        for (String name : names) {
            persons.add(new Person(name));
        }

        /*
         * @FunctionalInterface，传入String，返回Person
         * 接口的实现类（传统写法，代码较繁琐）；
         * Lambda表达式（只需列出参数名，由编译器推断类型）；
         * 符合方法签名的静态方法；
         * 符合方法签名的实例方法（实例类型被看做第一个参数类型）；
         * 符合方法签名的构造方法（实例类型被看做返回类型）。
         */
        List<Person> persons2 = names.stream().map(Person::new).collect(Collectors.toList());
        testConstructor();
    }

    public static void testConstructor() {
        List<String> names = List.of("Bob", "Alice", "Tim");

        // 传统方式
        List<Person> persons = new ArrayList<>();
        for (String name : names) {
            persons.add(new Person(name));
        }

        // 方法七：
        List<Person> persons2 = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons2);

    }
}
