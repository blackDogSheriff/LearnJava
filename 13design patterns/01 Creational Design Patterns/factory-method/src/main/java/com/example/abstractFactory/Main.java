package com.example.abstractFactory;

public class Main {
    public static void main(String[] args) {
        testFast();

    }

    public static void testFast() {
        AbstractFactory factory = new FastFactory();
        printDoc(factory);
    }

    public static void printDoc(AbstractFactory factory) {
        HtmlDocument htmlDocument = factory.createHtml();
        WordDocument wordDocument = factory.createWord();

        System.out.println(htmlDocument.toHtml());
        System.out.println(wordDocument.toWord());
    }
}
