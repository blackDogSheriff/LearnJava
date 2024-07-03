package com.example;

public class Main {
    public static void main(String[] args) {
        print();
        append();

        /*
         * return this
         */
        Adder adder = new Adder();
        adder.add(10).add(20).inc().add(30);
        System.out.println(adder.value());
    }

    public static void print() {
        String s = "";
        for (int i = 0; i < 100; i++) {
            //每次都会创建新的String，浪费内存，影响GC效率
            s = s + "," + i;
        }
        System.out.println(s);
    }

    public static void append(){
        // 预分配缓冲区
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 100; i++) {
            sb.append(',').append(i);
        }
        System.out.println(sb.toString());
    }
}