package com.example;

import java.util.List;
/*
 * - copy()方法内部不会读取dest，因为不能调用dest.get()来获取T的引用；
 * - copy()方法内部也不会修改src，因为不能调用src.add(T)。
 */

public class MyCllections<T> {
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            T t = src.get(i); // 只读
            dest.add(t); // 只写
        }

    }
}