package com.example;

/*
 * - 静态字段：属于类
 * - 静态方法：属于类，用来处理静态字段
 * - public目前看和普通的没区别 
 */

public class Person {
    public String name;
    public int age;

    // 静态字段类共享，不属于实例对象
    public static int number;

    //静态方法用于操作静态字段
    //通过类名调用
    // 由于静态方法不属于实例，静态方法不能访问this指针，也就不能调用实例字段
    public static void setNumber(int value) {
        number = value;
    }
}
