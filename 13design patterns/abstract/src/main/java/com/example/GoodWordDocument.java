package com.example;

import java.io.IOException;
import java.nio.file.Path;

public class GoodWordDocument implements WordDocument {
    String md;

    public GoodWordDocument(String md) {
        this.md = md;
    }

    @Override
    public void save(Path path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
