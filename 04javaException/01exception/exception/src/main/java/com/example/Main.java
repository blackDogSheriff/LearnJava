package com.example;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 * - RuntimeException以及它的子类；
 *  - 非RuntimeException（包括IOException、ReflectiveOperationException等等）
 * - Java规定：
 *  - 必须捕获的异常，包括Exception及其子类，但不包括RuntimeException及其子类，这种类型的异常称为Checked Exception。
 *  - 不需要捕获的异常，包括Error及其子类，RuntimeException及其子类。
 * 
 */

public class Main {
    public static void main(String[] args) {
        try {
            byte[] bs = toGBK("中文");
            System.out.println(Arrays.toString(bs));
        } catch (UnsupportedEncodingException e) {
            // 属于exception类下的IOException异常，必须捕获
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    // throws标识必须要捕获的异常
    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");
    }

    static byte[] toGBK1(String s) {
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}