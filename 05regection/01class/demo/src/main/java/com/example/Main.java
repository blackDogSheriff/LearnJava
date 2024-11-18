package com.example;

public class Main {
    public static void main(String[] args) throws Exception {
        String s = "hello";

        /*
         * 获取Class实例
         */
        Class cls = String.class;
        Class cls1 = s.getClass();
        Class clst = Class.forName("java.lang.String");

        /*
         * 比较
         */
        // Intenceof可以比较class以及是否为子类，但是==只能比较是否为一个class（JVM中实例唯一）
        Integer n = Integer.valueOf(123);
        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
        boolean b2 = n instanceof Number; // true，因为n是Number类型的子类

        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
        // boolean b4 = n.getClass() == Number.class; //
        // false，因为Integer.class!=Number.class

        printClassInfo("".getClass());
        //printClassInfo(Runnable.class);
        //printClassInfo(java.time.Month.class);
        //printClassInfo(String[].class); // 也是一种Class
        //printClassInfo(int.class); // JVM为基本类型也创建了Class实例，通过int.class访问

        // 缺点：只能调用public的无参构造方法。
        try {
            String s1 = (String) cls.newInstance(); // 通过class的Class实例来创建对象
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}