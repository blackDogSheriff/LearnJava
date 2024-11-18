package com.usetemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Number> list1 = new ArrayList<>();
        List<String> l = list; //向上转型

        // 没有定义泛型类型，默认泛型类型伟Object，编译警告
        List list = new ArrayList<>();
        list.add("hello");
        String first = (String) list.get(0);

        // 泛型类型为String
        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("world");

        String first1 = list1.get(0);
        String second1 = list1.get(1);

        // 泛型类型可以接收其子类对象
        List<Number> list2 = new ArrayList<>();
        list2.add(Integer.valueOf(123));
        list2.add(Double.valueOf(1.234));
        Number first2 = list2.get(0);
        Number second2 = list2.get(1);

        // 泛型接口
        String[] ss = new String[] { "Orage", "Apple", "Pear" };
        Arrays.sort(ss); // ss必须实现 Comparable<T>这个泛型接口

        Person[] ps = new Person[] {
                new Person("Bob", 51),
                new Person("Alice", 2),
                new Person("Lily", 33)
        };
        Arrays.sort(ps);

    }
}

class Person implements Comparable<Person> {
    String name;
    int score;

    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", score=" + score + "]";
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}
