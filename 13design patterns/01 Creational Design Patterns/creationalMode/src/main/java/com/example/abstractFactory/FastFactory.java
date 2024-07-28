package com.example.abstractFactory;

/*
 * FastFactory具体实现
 */
public class FastFactory implements AbstractFactory {
    @Override
    public WordDocument createWord() {
        return new FastWordDocument();
    }

    @Override
    public HtmlDocument createHtml() {
        return new FastHtmlDocument();
    }

}
