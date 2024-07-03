package com.example;

public class Main {
    public static void main(String[] args) {
        /*
         * 类型转换
         */
        Person person = new Person("xiaoming", 12);
        //向上转型(子类转父类)，允许
        Person person2 = new Student("xiaoming", 13, 100);
        //向下转型（父类转子类），不允许
        //Student student = new Person("xiaoming", 13);

        //可以使用instanceof判断是否可以转换
        Person person3 = new Student();
        if (person3 instanceof Student) {
            Student s = (Student)person3;
        }

        //也可以直接转型
        Person person4 = new Student();
        if (person4 instanceof Student s) {
            //此时s已经指向了person4的引用
        }

        /*
         * 继承和组合
         */

    }
}