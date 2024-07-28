package com.example.abstractFactory;

import java.nio.file.Path;

public class FastHtmlDocument implements HtmlDocument {
    @Override
    public void save(Path path) throws Exception {
        System.out.println("FastHtmlDocument save");
    }

    @Override
    public String toHtml() {
        return "FastHtmlDocument toHtml";
    }
}
