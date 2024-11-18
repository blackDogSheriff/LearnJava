package com.getfield;

public class Student extends Person {
    public int grade;
    private int score;

    public Student() {
        super();
        this.grade = 0;
        this.score = 0;
    }

    public Student(String name, String city, int grade, int score) {
        super(name, city);
        this.grade = grade;
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
