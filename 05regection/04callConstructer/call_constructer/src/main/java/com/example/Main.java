package com.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        callAnyConstuctor();
    }

    public static void callPublicNoArgsConstuctor() {
        Person p;
        try {
            // 只能调用 public的无参构造方法
            p = Person.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }
        p.setName("John");
    }

    @SuppressWarnings("rawtypes")
    public static void callAnyConstuctor() {
        Constructor c;
        try {
            c = Person.class.getConstructor(String.class);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
            return ;
        }

        System.out.println(c);
        Person p;
        try {
            p = (Person)c.newInstance("John");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
            return ;
        }
        System.out.println(p.getName());


    }
}