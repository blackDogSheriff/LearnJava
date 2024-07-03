package com.example;

//只能有一个父类
public class Student extends Person {
    private int score;

    public Student() {

    }

    public Student(String name, int age, int score) {
        // 调用父类构造方法
        super(name, age);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String hello() {
        // 三者等价
        return "Hello" + super.name;
        // return "Hello" + name;
        // return "Hello" + this.name;
    }
}
