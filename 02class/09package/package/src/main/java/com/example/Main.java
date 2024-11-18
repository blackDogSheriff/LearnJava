package com.example;

/*
 * Java 虚拟机执行的使用，只看完整的类名，因此只要包名不同类就不同；
 */

/* 
 * - 作用域 
 *  - 包作用域：不用public、private、protected修饰的字段和方法就是包作用域；同一个包中的类，可以访问包作用域的字段和方法；
 */

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.run();
    }
}

class Person {
    void run(){
        System.out.println("Main.run()");
    }
}