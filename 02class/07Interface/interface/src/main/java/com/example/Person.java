package com.example;

interface Person extends Hello{
    //接口可以有字段，必须为 public static final 类型
    public static final int MALE = 1;
    //不能定义成员变量
    void run();
    String getName();

    //可以定义default方法
    default void cry(){
        System.out.println(this.getName() +  " cry");
    }
}

/*
 * 问题：
 * - 接口public和
 */