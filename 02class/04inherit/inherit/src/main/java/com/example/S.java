package com.example;

public class S extends P {
    private int score;

    public S() {
        super("");
        this.score = 0;
    }

    public S(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
