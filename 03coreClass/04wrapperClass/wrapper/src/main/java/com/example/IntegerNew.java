package com.example;

/*
 * wrapper:
 * - 将基本类型编程引用类型
 */
public class IntegerNew{
    //所有的包装类型都是不变类，一旦创建了Integer，该对象是不变的
    private final int value;

    public IntegerNew(int value) {
        this.value = value;
    }

    public int intValue() {
        return this.value;
    }

}
