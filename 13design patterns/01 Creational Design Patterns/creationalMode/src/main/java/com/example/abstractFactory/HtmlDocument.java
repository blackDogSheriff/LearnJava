package com.example.abstractFactory;

import java.nio.file.Path;

public interface HtmlDocument {
    String toHtml();
    void save(Path path) throws Exception;
}
