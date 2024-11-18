package com.writetemplate;

//多个泛型类型
public class Pair<T, K> {
    private T first;
    private K last;

    public Pair(T first, K last) {
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

    /*
     * - 静态方法
     */
    public static <T, K> Pair<T, K> create(T first, K second) {
        return new Pair<T, K>(first, second);

    }
}