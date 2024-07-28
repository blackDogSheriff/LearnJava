package com.example.adapter;

import java.util.concurrent.Callable;

public class RunnableAdapter implements Runnable{
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
