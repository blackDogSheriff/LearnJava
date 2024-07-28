package com.example.adapter;

public class Main {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // 这里会抛出 ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("捕获到了异常: " + e.getMessage());
        }

        System.out.println("这是在 try-catch 之后的代码，它仍然会被执行。");
    }

}
