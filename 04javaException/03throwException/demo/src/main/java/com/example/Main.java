package com.example;

public class Main {

    public static void main(String[] args) throws IndexOutOfBoundsException {
        process1();
        // try {
        // process1();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        /*
         * catch中抛出异常，会先执行finally，然后再抛出异常
         */
        try {
            Integer.parseInt("jkdfs");
        } catch (Exception e) {
            System.out.println("catched");
            throw new RuntimeException();
        } finally {
            System.out.println("finally");
        }

        /*
         * 如果catch和finally中同时抛出异常，那么执行顺序为 1. catch，2 finall，
         * 3，finally抛出异常；因此catch中抛出的异常会被屏蔽
         */
        try {
            Integer.parseInt("jkdfs");
        } catch (Exception e) {
            System.out.println("catched");
            throw new RuntimeException();
        } finally {
            System.out.println("finally");
            // 目前会导致编译错误
            // throw new IllegalArgumentException();
        }

    }

    public static void process1() {
        // 如果没有处理异常，那么会抛到上层调用方法
        process2();
        // throw new RuntimeException();
    }

    public static void process2() {
        throw new IndexOutOfBoundsException();
    }

    public static void process3() {
        try {
            process4(null);
        } catch (NullPointerException e) {
            // 对抛出的异常进行转换了
            throw new IllegalArgumentException();
        }

    }

    public static void process4(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
    }
}