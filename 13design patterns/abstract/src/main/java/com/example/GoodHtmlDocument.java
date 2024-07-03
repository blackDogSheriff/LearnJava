package com.example;

import java.io.IOException;
import java.nio.file.Path;

public class GoodHtmlDocument implements HtmlDocument {
    String md;

    public GoodHtmlDocument(String md) {
        this.md = md;
    }

    @Override
    public String toHtml() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toHtml'");
    }

    @Override
    public void save(Path path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
