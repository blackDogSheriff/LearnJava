package com.getfield;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    private static final String DELIMITER = "------------------------------------------------------";
    private static final String DELIMITER1 = "======================================================";

    public static void main(String[] args) throws Exception {
        Class stc = Student.class;
        printFields(stc);
        printLine1();

        printFieldInfo();
        printLine1();

        Student s = new Student("wang", "shanghai", 123, 10);
        printFieldValue(s);

    }

    /*
     * 通过Field打印对象的字段值
     */
    static void printFieldValue(Object obj) throws Exception {
        Class stc = obj.getClass();
        for (Field field : stc.getDeclaredFields()) {
            // 设置访问权限，private的字段也可以访问
            field.setAccessible(true);
            System.out.println(field.getName() + ":" + field.get(obj));

            // 设置字段的值
            field.set(obj, 100);
            System.out.println(field.getName() + ":" + field.get(obj));
        }
    }

    /*
     * 打印Filed信息
     */
    static void printFieldInfo() throws NoSuchFieldException, SecurityException {
        Field f = String.class.getDeclaredField("value");

        System.out.println(f.getName());
        System.out.println(f.getType());

        int m = f.getModifiers();
        System.out.println(Modifier.isPublic(m));
        System.out.println(Modifier.isProtected(m));
        System.out.println(Modifier.isPrivate(m));
        System.out.println(Modifier.isStatic(m));
        System.out.println(Modifier.isFinal(m));

    }

    /*
     * 打印class中的Field
     */
    static void printFields(Class stc) throws NoSuchFieldException, SecurityException {
        /*
         * 获取当前类中定义的所有Field
         */
        for (Field field : stc.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        printLine();

        /*
         * 获取子类和父类中 public 的字段
         */
        for (Field field : stc.getFields()) {
            System.out.println(field.getName());
        }
        printLine();

        /*
         * 获取子类和父类中某个public的字段
         */
        System.out.println(stc.getField("name").getName());
        printLine();

        /*
         * 获取子类中某个字段
         */
        System.out.println(stc.getDeclaredField("grade").getName());
    }

    static void printLine() {
        System.out.println(DELIMITER);
    }

    static void printLine1() {
        System.out.println(DELIMITER1);
    }
}