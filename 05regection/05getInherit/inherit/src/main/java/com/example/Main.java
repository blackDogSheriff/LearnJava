package com.example;

public class Main {
    public static void main(String[] args) {
        getSuperClass();
        System.out.println("================================================");
        getInterface();
        System.out.println("================================================");
    }

    @SuppressWarnings("rawtypes")
    public static void getSuperClass(){
        System.out.println(Integer.class.getSuperclass());
        System.out.println(Integer.class.getSuperclass().getSuperclass());
    }

    @SuppressWarnings("rawtypes")
    public static void getInterface(){
        //只返回当前类直接实现的接口类型，不处理父类实现的接口类型
        Class[] is = Integer.class.getInterfaces();
        for (Class i : is){
            System.out.println(i);
        }
    }

    public static void getInherit() {
    }
}