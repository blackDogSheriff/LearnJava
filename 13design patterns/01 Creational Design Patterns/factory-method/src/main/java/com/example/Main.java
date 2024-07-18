package com.example;

public class Main {
    public static void main(String[] args) {
        testFactory();
    }

    public static void testFactory() {
        NumberFactory factory = NumberFactory.getFactory();
        Number result = factory.parse("123");
    }
}