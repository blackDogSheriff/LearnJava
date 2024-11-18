package com.example.person;


//不允许子类覆写
final public class P {
    private String name;
    private int age;

    //不允许子类继承
    final public String hello() {
        return "hello";
    }
}
