package com.writetemplate;

//多个泛型类型
public class Pair1<T, K> {
    private T first;
    private K last;

    public Pair1(T first, K last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public K getLast() {
        return last;
    }

    public void setLast(K last) {
        this.last = last;
    }
}