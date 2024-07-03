package com.example;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/*
 * - 通常把一组对应的读写方法:getter,setter称之为属性（读写）；
 */

//
/*
 * java bean 特征：
 * - 提供一个默认的无参构造函数
 * - 需要被序列化，并且提供序列化接口
 * - 有一系列的可读写属性，一般是private的；
 * - 有一系列的getter，setter方法；
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println(" " + pd.getReadMethod());
            System.out.println(" " + pd.getWriteMethod());

        }
    }
}