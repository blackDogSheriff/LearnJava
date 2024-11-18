package com.example;


/*
 * - 接口
 *  - 所有方法都是抽象方法
 *  - 接口中所有方法定义都是默认 public abstrat，因此不需要手动添加abstract关键字 
 *  - 子类实现接口需要使用implement关键字
 *  - 子类可以实现多个interface
 *  - 一个interfact可以使用extends继承另一个接口
 *  - 使用default定义default方法，default方法无法访问字段（抽象类中的非抽象方法可以）
 *  - 接口可以有默认字段，必须是public static final类型
 */
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