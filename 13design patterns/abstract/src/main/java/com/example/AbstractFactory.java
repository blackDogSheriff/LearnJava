package com.example;

public interface AbstractFactory {
    // create Html
    HtmlDocument creatHtml(String md);

    // create Word
    WordDocument createWord(String md);

    public static AbstractFactory createFactory(String name) {
        if (name.equalsIgnoreCase("fast")) {
            return new FastFactory();
        } else if (name.equalsIgnoreCase("good")) {
            return new GoodFactory();
        } else {
            throw new IllegalArgumentException("Invalid factory name: " + name);
        }
    }

}
