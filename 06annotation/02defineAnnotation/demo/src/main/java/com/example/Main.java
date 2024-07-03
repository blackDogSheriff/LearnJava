package com.example;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        getAnnotationValue();
    }

    public static void getAnnotationValue() {
        if (Person.class.isAnnotationPresent(Report.class)) {
            Report report = Person.class.getAnnotation(Report.class);
            System.out.println(report.type());
        }
    }

    static void check(Person person) throws IllegalArgumentException, IllegalAccessException {
        // 遍历所有fields
        for (Field field : Person.class.getFields()) {

            // 判断是否包含Range注解
            if (!field.isAnnotationPresent(Range.class)) {
                return;
            }

            Range range = field.getAnnotation(Range.class);

            // 获取fields的value
            Object value = field.get(person);
            // 处理String类型
            if (value instanceof String s) {
                if (s.length() < range.min() || s.length() > range.max()) {
                    throw new IllegalArgumentException("Invalid value for " + field.getName());
                }
            }
        }
    }

}