package com.example.hong;

public class Person {

    /*
     * 包作用域：
     * - 不用public、private、protected字段修饰的字段和方法就是包作用域；
     * - 可被同包重其他类/对象调用；
     */
    void hello() {
        System.out.println("Hello");
    }

    void run() {
        System.out.println("hong.run()");
    }

}
