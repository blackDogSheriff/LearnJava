package com.example;

import java.io.IOException;
import java.nio.file.Path;

public interface WordDocument {
    public void save(Path path) throws IOException;
}
