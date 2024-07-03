package com.example;

public class Main {
    public static void main(String[] args) {
        IntegerNew n = null;
        IntegerNew n2 = new IntegerNew(10);
        int n3 = n2.intValue();
        System.out.println("Hello world!");

        /*
         * 使用java核心库提供的包装类型
         */
        int i = 100;
        // 通过new创建：不推荐
        Integer in1 = new Integer(i);
        // 通过valueOf(String)：
        Integer in2 = Integer.valueOf(i);
        // 通过valueOf
        Integer in3 = Integer.valueOf("100");

        /*
         * 相互转换
         */
        Integer n4 = Integer.valueOf(i);
        int x = n4.intValue();

        // 编译器会自动转换
        int x1 = n4; // 调用Integer.intValue();

        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
        System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制

        /*
         * 包装类中的静态类型
         */
        // boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
        // int可表示的最大/最小值:
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648
        // long类型占用的bit和byte数量:
        int sizeOfLong = Long.SIZE; // 64 (bits)
        int bytesOfLong = Long.BYTES; // 8 (bytes)

    }
}