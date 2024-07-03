package com.example;
/*
 * 工厂思维：
 * 抽象工厂获取实例，返回所需要的对象，但是忽略工厂实现的具体对象和方法
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumberFactory factory = NumberFactory.getFactory();
        System.out.println(factory.parse("123"));

        // 无法看到实现细节，内部进行了优化，返回的可能是cache，而不是new
        Integer n = Integer.valueOf(100);
        // 每次都创建一个新的产品
        Integer n1 = new Integer(200);

        List<String> list = List.of("d", "e", "f");
    }
}