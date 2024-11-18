package com.example.abstractFactory;

public class Main {
    public static void main(String[] args) {
        testFast();

    }

    public static void testFast() {
        /*
         * 创建工厂类型
         * - 每种工厂生产的方法相同，产品不同
         * - 工厂抽象、产品抽象
         * - 实例化工厂，实例化工厂对应的产品
         */
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
