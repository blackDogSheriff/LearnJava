package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> args = new ArrayList<String>();
    static List<Thread> threads = new ArrayList<Thread>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread start");
                    try {
                        addNode();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printNode();
    }

    public static void addNode() throws InterruptedException {
        System.out.println("enter addNode");
        while (args.size() == 0) {
            System.out.println("before to add.");
            synchronized (args) {
                System.out.println("start to add.");
                args.add("123");
            }
        }
        System.out.println("size:" + args.size());
    }

    public static void printNode() {
        for (String arg : args) {
            System.out.println(" " + arg);
        }
    }
}