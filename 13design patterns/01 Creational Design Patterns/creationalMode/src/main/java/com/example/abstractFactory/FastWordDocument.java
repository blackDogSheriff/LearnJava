package com.example.abstractFactory;

import java.nio.file.Path;

public class FastWordDocument implements WordDocument {
    @Override
    public void save(Path path) throws Exception {
        System.out.println("Saving document to " + path);
    }

    @Override
    public String toWord() {
        return "Fast Word Document";
    }

}
