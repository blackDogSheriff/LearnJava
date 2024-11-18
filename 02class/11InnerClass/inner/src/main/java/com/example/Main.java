package com.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        /*
         * Inner classes
         */
        Outer outer = new Outer("Nested");

        // 实例化Inner需要通过Outer实例
        Outer.Inner inner = outer.new Inner();
        inner.hello();

        /*
         * Anonymous classes
         */
        HashMap<String, String> map = new HashMap<String, String>(); // 创建了一个对象
        HashMap<String, String> map2 = new HashMap<String, String>() {
        }; // 相当于是一个继承后没有修改的匿名类
        HashMap<String, String> map3 = new HashMap<String, String>() {
            {
                put("A", "1");
            }
        }; // 继承自HashMap，并且添加了static初始化代码块

        /*
         * Static Nested classes
         */

        // 独立类，但是拥有Outer的访问权限
        Outer.StaticNested os = new Outer.StaticNested();
        os.hello();
    }
}