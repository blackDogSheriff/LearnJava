package com.example;

public class FastFactory implements AbstractFactory {

    @Override
    public HtmlDocument creatHtml(String md) {
        return new FastHtmlDocument(md);
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument(md);
    }

}
