package com.example;

import java.math.BigDecimal;

public interface NumberFactory {
    Number parse(String s);

    // 创建静态对象
    static NumberFactoryImpl impl = new NumberFactoryImpl();

    // 返回class的静态实例
    static NumberFactory getFactory() {
        return impl;
    }

    /*
     * 静态工厂方法
     */
    public static Number parse1(String s) {
        return new BigDecimal(s);
    }
}
