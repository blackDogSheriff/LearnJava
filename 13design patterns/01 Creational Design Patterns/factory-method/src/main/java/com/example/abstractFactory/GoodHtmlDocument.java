package com.example.abstractFactory;

import java.nio.file.Path;

public class GoodHtmlDocument implements HtmlDocument {
    @Override
    public String toHtml() {
        return "GoodHtmlDocument to Html";
    }

    @Override
    public void save(Path path) throws Exception {
        System.out.println("GoodHtmlDocument save to " + path);
    }

}
