package com.example;

import java.io.IOException;

/*
 * - 多个catch只会执行一个
 * - Exception子类异常必须写在前面，否则永远捕获不到
 * - final
 */

public class Main {
    public static void main(String[] args) {
        try {
            process1();
            process2();
            process3();

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }

    public static void process1() {
        throw new RuntimeException();
    }

    public static void process2() {
        throw new NullPointerException();
    }

    public static void process3() throws IOException {
        throw new IOException();
    }
}