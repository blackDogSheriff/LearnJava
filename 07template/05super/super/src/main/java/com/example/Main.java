package com.example;
/*
 * - 允许调用set(? super Integer)传入 Integer的引用
 * - 不允许调用get()获得Integer的引用；
 * - 唯一例外的是可以使用Object获得引用Object o = p.getFirst()
 * 换句话说，使用<? super Integer>通配符作为方法参数，表示可写不可读
 */

public class Main {
    public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        // setFirst的签名实际上是 void setFirst(? super Integer);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
        System.out.println("Hello world!");
    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }

    // java还允许定义无限定通配符
    // 不允许调用set(T)方法并传入引用（NULL除外）
    // 不允许调用T get()方法并获取T引用（只能获取object引用）
    // 只能做一些非空判断
    static boolean sample(Pair<?> p) {
        return p.getFirst() == null || p.getLast() == null;
    }
}
