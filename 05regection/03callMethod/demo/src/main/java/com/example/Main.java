package com.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        printStudentMethods();
        System.out.println("============================================================");
        callMethods();
        System.out.println("============================================================");
        callStaticMethods();
        System.out.println("============================================================");
        polymorphism(); // 任然是运行时绑定
    }

    @SuppressWarnings("unchecked")
    public static void printStudentMethods() {
        @SuppressWarnings("rawtypes")
        Class stdClass = Student.class;
        try {
            // 获取public的方法
            System.out.println(stdClass.getMethod("getName"));
            System.out.println(stdClass.getMethod("getGrade", int.class));
            // 获取所有的方法
            System.out.println(stdClass.getDeclaredMethod("getScore", String.class));
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public static void callMethods() {
        String s = "Hello world!";
        try {
            Method m = String.class.getMethod("substring", int.class, int.class);
            m.setAccessible(true);
            String r = (String) m.invoke(s, 6, 7);
            System.out.println(r);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void callStaticMethods() {
        try {
            Method m = Integer.class.getMethod("parseInt", String.class);
            m.setAccessible(true); // 对非public情况处理
            // 由于静态方法不绑定实例，因此第一个参数填null
            Integer r = (Integer) m.invoke(null, "12345");
            System.out.println(r);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void polymorphism() {
        Method h;
        try {
            h = Person.class.getMethod("hello");
            h.invoke(new Student(), null);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
