package com.example;

import java.io.IOException;
import java.nio.file.Path;

public class FastWordDocument implements WordDocument {
    String md;

    public FastWordDocument(String md) {
        this.md = md;
    }

    @Override
    public void save(Path path) throws IOException {
    }
}
