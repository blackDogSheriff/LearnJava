package com.example.abstractFactory;

public class GoodFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml() {
        return new GoodHtmlDocument();
    }

    @Override
    public WordDocument createWord() {
        return new GoodWordDocument();
    }
}
