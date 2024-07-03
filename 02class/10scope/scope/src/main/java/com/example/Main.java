package com.example;

import com.example2.Hello;

public class Main {
    public static void main(String[] args) {
        Hello hl = new Hello();
        //hl.run(); // 包作用域的字段或者方法只能被同包类访问
        hl.run1(); // public作用域可以被任何类访问


        // PackageHello hl3 = new PackageHello(); //包作用域的class只能被同包类访问
        PackageHello1 hl4 = new PackageHello1(); 

        // private修饰的字段或者方法，不能被其他类访问；

        /*
         * public修饰的类或者方法：
         * - 可以被任意类访问；
         * - 访问public方法必须要有class的访问权限
         */

        /*
         * protected：修饰的类或者方法
         * - 可以被子类或者子类的子类访问
         */

        /* private：
         * - 只能被自身访问或者嵌套类访问
         */

        /*
         * package：
         * - 没有public、private、protected修饰的类或者方法
         * - 可以被同一个包里的类访问
         * - 包名必须完全一致
         */

        /* 局部变量：
         * - 局部变量作用域从声明处开始到对应的块结束；
         */


        /*
         * 查找顺序：
         * - package
         * - import导入的类
         * - java.lang中是否定义
         */

         /*
          * final
          * - 修饰class：不可被继承
          * - 修饰method：不可覆写
          * - 修饰变量：不可重新赋值
          * - field：类的变量；
          * - 局部变量：方法中定义的变量
          */
    }
}
