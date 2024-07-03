package com.example;

import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        // 遍历添加
        String[] names = { "Bob", "Alice", "Grace" };
        var sb = new StringBuilder();
        sb.append("Hello, ");
        for (String name : names) {
            sb.append(name).append(",");
        }
        System.out.println(sb.toString());
        sb.delete(sb.length() - 1, sb.length());
        sb.append("!");
        System.out.println(sb.toString());

        // 使用StringJoiner
        var sb1 = new StringJoiner(",", "Hello, ", "!");
        for (String name : names) {
            sb1.add(name);
        }
        System.out.println(sb1.toString());

        // 使用String.join
        var sb2 = String.join(", ", names);
        Integer.valueOf(20);
    }

}