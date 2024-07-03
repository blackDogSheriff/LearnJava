package com.example;

class Outer {
    private static String NAME = "OUTER";
    private String name;

    Outer(String name) {
        this.name = name;
    }

    class Inner { // 编译后的名称为 Outer$Inner.class
        void hello() {
            // Inner class可以访问Outer的private成员
            System.out.println("Hello!" + Outer.this.name);
        }
    }

    /*
     * - 还有一种定义Inner Class的方法，不需要再Outer中明确定义，而是在方法内部通过匿名类（Anonymous Class）来定义
     */
    void asyncHello() {
        // Runnable为接口不能实例化，实际是定义了一个实现Runnable的匿名类，通过new实例化该匿名类
        // 观察Java编译器编译后的.class文件发现，Outer被编译为Outer.class，而匿名类被编译成Outer$1、Outer$2形式
        Runnable r = new Runnable() { // 编译完为Outer$1.class
            @Override
            public void run() {
                System.out.println("Hello!" + Outer.this.name);
            }
        };
        new Thread(r).start();
    }

    // 第三种内部类和Inner Class类似，但是使用static修饰，称之为静态内部类
    // 不再依附Outer实例，而是一个独立的类，也无法引用Outer.this，但是可以访问Outer的private静态字段和静态方法
    static class StaticNested {
        void hello() {
            System.out.println("Hello!" + Outer.NAME);

        }
    }
}
