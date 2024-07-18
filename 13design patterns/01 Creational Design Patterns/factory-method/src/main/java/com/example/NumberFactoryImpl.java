package com.example;

import java.math.BigDecimal;

public class NumberFactoryImpl implements NumberFactory {
    /*
     * - 接口具体实现
     */
    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }

}
