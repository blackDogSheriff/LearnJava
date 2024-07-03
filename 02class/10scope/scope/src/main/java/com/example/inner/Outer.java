package com.example.inner;

public class Outer {
    private static void hello() {
        System.out.println("Hello!");
    }

    //静态内部类
    static class Inner {
        public void hi() {
            //嵌套类拥有private权限
            Outer.hello();
            hello();
        }
    }

}
