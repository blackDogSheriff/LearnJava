package com.example;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.createFactory("fast");
        factory.creatHtml("md");
        factory.createWord("123");
    }
}
