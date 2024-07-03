package com.example;

public interface MyList<T> {
    int size();

    T get(int index);

    void add(T t);

    void remove(T t);
}