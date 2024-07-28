package com.example.singleton;

public class Singleton {
    /*
     * 创建实例
     */
    private static Singleton instance = new Singleton();
    public Singleton getInstance() {
        return instance;
    }

    //直接静态字段，引用唯一实例，暴露给外部
    //public static final Singleton instance = new Singleton();

    /*
     * 私有化构造函数，保证外部无法实例化
     */
    private Singleton() {

    }

}
