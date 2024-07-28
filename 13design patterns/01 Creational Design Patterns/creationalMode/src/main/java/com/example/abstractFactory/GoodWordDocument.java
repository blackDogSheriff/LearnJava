package com.example.abstractFactory;

import java.nio.file.Path;

public class GoodWordDocument implements WordDocument {
    @Override
    public void save(Path path) throws Exception {
        System.out.println("Saving to " + path);
    }

    @Override
    public String toWord() {
        return "Good Word Document";
    }
}
