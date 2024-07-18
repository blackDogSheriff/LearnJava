package com.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        testFactory();
    }

    public static void testFactory() {
        NumberFactory factory = NumberFactory.getFactory();
        Number result = factory.parse("123");
    }

    public static Number parse(String s) {
        return new BigDecimal(s);
    }
}