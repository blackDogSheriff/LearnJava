package com.example.prototype;

public class Student implements Cloneable {
    private int i;
    private String name;
    private int score;
    private int id;

    public Student(int i, String name, int score) {
        this.id = i;
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    @Override
    public Object clone() {
        Student student = new Student();
        student.id = this.id;
        student.name = this.name;
        student.score = this.score;
        return student;
    }

    public Student copy() {
        Student student = new Student();
        student.id = this.id;
        student.name = this.name;
        student.score = this.score;
        return student;
    }

}
