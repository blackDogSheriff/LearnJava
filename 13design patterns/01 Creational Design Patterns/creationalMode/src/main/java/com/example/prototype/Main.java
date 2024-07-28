package com.example.prototype;

public class Main {
    public static void main(String[] args) {
        String[] s = new String[]{"1", "2", "3"};
        String copy_s = String.copyValueOf(s, 0, 3);
    }

}
