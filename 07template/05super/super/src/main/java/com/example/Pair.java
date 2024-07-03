package com.example;

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    // 不能使用Integer来接受返回值，会报错，只能使用Object来接受（父类接收子类）
    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    // 允许传入Pair<Integer>，不能传入Pair<Number>
    void set(Pair<Integer> p, Integer first, Integer last) {
        p.setFirst(first);
        p.setLast(last);
    }

    // 允许传入Integer或者其父类
    void set1(Pair<? super Integer> p, Integer first, Integer last) {
        p.setFirst(first);
        p.setLast(last);
    }
}
