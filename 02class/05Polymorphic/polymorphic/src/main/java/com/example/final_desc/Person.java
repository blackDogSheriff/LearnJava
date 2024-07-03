package com.example.final_desc;

//类不允许被继承
final class Person {
    //final修饰成员无法赋值操作
    final String CONSTENT_VAL = "person";
    protected String name;

    // final 修饰方法，方法无法被子类覆写
    public final String hello() {
        return "hello, " + name;
    }
}
