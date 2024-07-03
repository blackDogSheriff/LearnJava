package com.example;

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