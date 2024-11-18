package useset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ArrayList
        List<String> list = new ArrayList<>();
        list.add("apple"); // size=1
        list.add("pear"); // size=2
        list.add("apple"); // 允许重复添加元素，size=3
        System.out.println(list.size());

        /*
         * 添加
         */
        // List还允许添加NULL，占用一个元素
        list.add(null); // size=2

        /*
         * 创建
         */
        // 创建List，通过of批量添加
        List<Integer> list1 = List.of(1, 2, 3);

        /*
         * 遍历
         */
        // 遍历List，不推荐
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }


        // 使用迭代器遍历
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            String s = it.next();
            System.out.println(s);
        }

        // 使用for each遍历，自带Iterator迭代器进行遍历
        for (String s : list) {
            System.out.println(s);
        }

        /*
         * List转Array
         */
        Object[] array = list.toArray();
        for (Object s : array) {
            System.out.println(s);
        }

        Integer[] array1 = list.toArray(new Integer[3]);
        for (Integer n : array1) {
            System.out.println(n);
        }

        /*
         * 如果我们传入的数组大小和List实际的元素个数不一致怎么办？根据List接口的文档，我们可以知道：
         * 
         * 如果传入的数组不够大，那么List内部会创建一个新的刚好够大的数组，填充后返回；如果传入的数组比List元素还要多，那么填充完元素后，
         * 剩下的数组元素一律填充null。
         */
        Number[] array2 = list.toArray(new Number[3]);
        for (Number n : array2) {
            System.out.println(n);
        }

        // 传入恰好一样大小的数组
        Integer[] array3 = list.toArray(new Integer[list.size()]);

        // 最后一种更简洁的写法是通过List接口定义的T[] toArray(IntFunction<T[]> generator)方法
        // 函数式写法
        Integer[] array4 = list.toArray(Integer[]::new);

        /*
         * Array转List
         */
        // 返回的List只是一个接口，只读，不可以add、remove
        Integer[] array5 = { 1, 2, 3 };
        List<Integer> list2 = List.of(array5);

    }
}