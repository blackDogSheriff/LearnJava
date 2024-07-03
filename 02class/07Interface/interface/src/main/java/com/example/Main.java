package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 可以查看继承关系
        // 通过接口引用实例化对象（继承关系，接口更抽象）
        List<Student> ls = new ArrayList<Student>();
        Collection coll = ls;
        Iterable<Student> is = coll;
    }
}