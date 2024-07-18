package com.example.abstractFactory;

public interface AbstractFactory {
    HtmlDocument createHtml();

    WordDocument createWord();
}
