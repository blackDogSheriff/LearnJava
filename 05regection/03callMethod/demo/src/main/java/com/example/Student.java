package com.example;

public class Student extends Person {
    public int getScore(String type) {
        return 99;
    }

    public int getGrade(int year) {
        return 1;
    }

    @Override
    public void hello() {
        System.out.println("Student: hello");
    }
}