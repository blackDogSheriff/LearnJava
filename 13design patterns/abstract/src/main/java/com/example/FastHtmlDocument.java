package com.example;

import java.io.IOException;
import java.nio.file.Path;

public class FastHtmlDocument implements HtmlDocument {
    String md;

    public FastHtmlDocument(String md) {
        this.md = md;
    }

    @Override
    public String toHtml() {
        return "fsdjk";
    }

    @Override
    public void save(Path path) throws IOException {
    }

}