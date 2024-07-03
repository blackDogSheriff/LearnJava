package com.example;

public class PairHelper {
    static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    static int add1(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    static int add2(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        //
        /*
         * p.setFirst(Integer.valueOf(first.intValue() + 100));
         * p.setLast(Integer.valueOf(last.intValue() + 100));
         */
        return p.getFirst().intValue() + p.getFirst().intValue();
    }

}
