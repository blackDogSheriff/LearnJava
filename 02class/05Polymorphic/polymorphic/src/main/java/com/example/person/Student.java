package com.example.person;

public class Student extends Person{
    //覆写：子类覆盖父类方法
    @Override
    public void run(){
        System.out.println("Student.run()");
    }
}
