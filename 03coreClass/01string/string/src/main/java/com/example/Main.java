package com.example;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        String s1 = "Hello, world";
        // 实际字符串内部是通过一个char[]数组表示的
        // String 的一个重要的特点就是不可变 'private final char[]', 而且没有修改char[]的方法实现
        String s2 = new String(new char[] { 'H', 'e', 'l', 'l', 'o', ',', 'w', 'o',
                'r', 'l', 'd' });
        System.out.println("Hello world!");

        // 字符串是否改变？
        String s = "Hello";
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);

        // 两个字符串比较必须使用 equals
        String s3 = "hello";
        String s4 = "HELLO".toLowerCase();
        System.out.println(s3 == s4); // 指向相同的常量池对象，结果为true
        System.out.println(s3.equals(s4));

        // 包含
        System.err.println("Hello".contains("ll"));

        // 搜索
        System.out.println("Hello".indexOf("l")); // 2
        System.out.println("Hello".lastIndexOf("l")); // 3
        System.out.println("Hello".startsWith("He")); // true
        System.out.println("Hello".endsWith("lo")); // true

        // 提取
        System.out.println("Hello".substring(2));// "llo"
        System.out.println("Hello".substring(2, 4)); // "ll"

        // 去除首位空白，trim是返回了一个新的字符串
        System.out.println("  \tHello\r\n ".trim()); // "Hello"
        // 另一个strip()方法也可以移除字符串首尾空白字符。它和trim()不同的是，类似中文的空格字符\u3000也会被移除：
        String s5 = " Hello ";
        System.out.println("\u3000Hello\u3000".strip()); // "Hello"
        System.out.println(s5.stripLeading());// "Hello "
        System.out.println(" Hello ".stripTrailing()); // " Hello"

        // 判空
        System.out.println("".isEmpty()); // true，因为字符串长度为0
        System.out.println("  ".isEmpty()); // false，因为字符串长度不为0
        System.out.println("  \n".isBlank()); // true，因为只包含空白字符
        System.out.println(" Hello ".isBlank()); // false，因为包含非空白字符

        // 替换
        String s6 = "hello";
        s6.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        s6.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
        String s7 = "A,,B;C ,D";
        s7.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"

        // 分割
        String s8 = "A,B,C,D";
        String[] ss = s8.split("\\,"); // {"A", "B", "C", "D"}

        // 拼接
        String[] arr = { "A", "B", "C" };
        String s9 = String.join("***", arr); // "A***B***C"

        // 格式化
        String s10 = "Hi %s, your score is %d!";
        System.out.println(s10.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));

        // 类型转换
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c

        // String to Integer
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255
        // 获取环境变量的int值
        Integer.getInteger("java.version"); // 版本号，11
        // String to Char
        char[] cs = "Hello".toCharArray(); // String -> char[]
        // Char to String
        String s11 = new String(cs); // char[] -> String

        // 编码转换
        byte[] b1 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
        try {
            byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
            byte[] b3 = "Hello".getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            System.out.println("Get char set error;");
            e.printStackTrace();
        } // 按GBK编码转换
        byte[] b4 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换

    }
}