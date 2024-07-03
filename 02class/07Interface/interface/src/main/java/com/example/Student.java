package com.example;

// 一个类可以实现多个接口
public class Student implements Person{
    private String name;


    public Student(String name){
        this.name = name;
    }
    @Override
    public void hello(){
        System.out.println(this.name + " hello");
    }

    @Override
    public void run() {
        System.out.println(this.name + " run");
    }

    @Override
    public String getName(){
        return this.name;
    }
    

}
