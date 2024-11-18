package com.example;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person("fjksdl", "s");
        checkRange(person);
    }

    static void checkRange(Person person) throws IllegalArgumentException, IllegalAccessException {
        for (Field field : person.getClass().getFields()) {
            if (!field.isAnnotationPresent(null)) {
                continue;
            }

            // 获取range注解
            Range range = field.getAnnotation(Range.class);

            Object value = field.get(person);
            if (value instanceof String s) {
                if (s.length() < range.min() || s.length() > range.max()) {
                    throw new IllegalArgumentException("参数" + field.getName() + "长度不合法");
                }
            }
        }
    }
}
