package com.getfield;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

//文件中public类只能有一个
public class Main {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {

        Class stdClass = Student.class;
        // Class stdClass = Class.forName("com.getfield.Student");
        // obj.getClass();
        printFields(stdClass);
        System.out.println("================================================");
        printFieldInfo();
        System.out.println("================================================");
        getObjectFieldValue();

    }

    @SuppressWarnings("rawtypes")
    public static void printFields(Class stdClass) {
        try {
            // 获取当前类的某个field，不区分public和private还有父子类
            System.out.println("grade: " + stdClass.getDeclaredField("grade"));

            // 获取某个public的field，包括父类
            System.out.println("score: " + stdClass.getField("score"));
            System.out.println("name: " + stdClass.getField("name"));

            System.out.println();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void printFieldInfo() {
        try {
            Field f = String.class.getDeclaredField("value");
            System.out.println("name: " + f.getName());
            System.out.println("type: " + f.getType());

            int m = f.getModifiers();
            System.out.println(Modifier.isFinal(m));
            System.out.println(Modifier.isPublic(m));
            System.out.println(Modifier.isProtected(m));
            System.out.println(Modifier.isPrivate(m));
            System.out.println(Modifier.isStatic(m));

        } catch (Exception e) {

        }
    }

    @SuppressWarnings("rawtypes")
    public static void getObjectFieldValue() {
        /*
         * 获取实例的字段值
         */
        try {
            Person p = new Person("John");
            // get class
            Class c = p.getClass();

            // field
            Field f1 = c.getDeclaredField("name");

            // 不管字段是不是public，都允许访问
            f1.setAccessible(true);

            //get
            Object value = f1.get(p);
            System.out.println(value);

            //set
            f1.set(p, "Xiao Hong");
            System.out.println(p.getName());
        } catch (Exception e) {
        }

    }

}
