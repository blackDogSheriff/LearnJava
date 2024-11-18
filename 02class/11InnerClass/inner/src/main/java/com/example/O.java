package com.example;

public class O {
    private String name;
    final private int age;

    public O() {
        this("", 0);
    }

    public O(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public class I {
        private int score;
        public I(int score) {
            this.score = score;
        }

        public void echo() {
            System.out.println(O.this.name);
        }
    }


}
