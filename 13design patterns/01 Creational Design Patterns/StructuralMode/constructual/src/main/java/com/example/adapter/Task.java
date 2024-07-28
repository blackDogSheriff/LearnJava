package com.example.adapter;

import java.util.concurrent.Callable;

public class Task implements Callable<Long> {
    private long num;

    public Task(long num) {
        this.num = num;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (long i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}
