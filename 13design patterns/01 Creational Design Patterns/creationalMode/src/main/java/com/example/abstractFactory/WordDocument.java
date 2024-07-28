package com.example.abstractFactory;

import java.nio.file.Path;

public interface WordDocument {
    String toWord();

    void save(Path path) throws Exception;
}
