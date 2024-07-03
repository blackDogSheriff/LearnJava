package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int sum = PairHelper.add(new Pair<Number>(1, 2));
        // 编译报错，Pair<Number>和Pair<Integer>类型不匹配
        // int sum1 = PairHelper.add(new Pair<Integer>(1, 2));

        // 可以通过使用Pair<? extends Number>来使方法接收所有Number或者Number子类的Pair类型
        // 可以传递 Pair<Integer>、Pair<Double>、Pair<BigDecimal>等所有Number子类的泛型
        int sum1 = PairHelper.add1(new Pair<Integer>(1, 2));
        // Number x = p.getFirst();实际的方法签名变成了 <? extends Number> getFirst();

        // 但是不能确保每次传入的都是Integer对象，例如
        // Integer x = p.getFirst();是无法通过编译的；

        // 不能指定setFirst的入参类型，因为接收的类型可能是Pair<Double>，Pair<Double>的setFirst参数类型肯定不是Integer
        int sum2 = PairHelper.add2(new Pair<Integer>(123, 456));

        /*
         * extends通配符的作用
         */
    }

    // List<? extends Number>不允许通过list调用set(? extends
    // Integer)并传入任何引用，表明该方法内部只会读取list的元素；
    int sumOfList(List<? extends Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer n = list.get(i);
            sum += n;
        }
        return sum;
    }
}
