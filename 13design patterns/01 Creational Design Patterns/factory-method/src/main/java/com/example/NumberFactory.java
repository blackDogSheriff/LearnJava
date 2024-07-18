package com.example;

/*
 * Factory Method
 * - 提供接口定义
 * - 创建返回实例
 * 
 */
public interface NumberFactory {
    public Number parse(String s);

    static NumberFactory impl = new NumberFactoryImpl();

    static NumberFactory getFactory() {
        return impl;
    }
}
