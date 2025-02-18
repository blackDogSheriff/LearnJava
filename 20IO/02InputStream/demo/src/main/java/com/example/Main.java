package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws IOException {
        InputStream is = new FileInputStream("C:\\Users\\93786\\Desktop\\111\\22.txt");
        for (;;) {
            int n = is.read();
            if (n == -1) {
                break;
            }
            System.out.println(n);
        }
        is.close();
    }
}