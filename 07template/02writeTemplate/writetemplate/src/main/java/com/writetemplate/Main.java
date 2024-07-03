package com.writetemplate;

public class Main {
    public static void main(String[] args) {
        // 多个泛型类型，使用的时候只需要指定各个泛型类型
        Pair1<String, Integer> p1 = new Pair1<>("test", 123);
    }
}
