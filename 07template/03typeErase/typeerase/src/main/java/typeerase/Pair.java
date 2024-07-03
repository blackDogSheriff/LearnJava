package typeerase;

import java.lang.reflect.InvocationTargetException;

public class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public Pair() {
    }

    public Pair(Class<T> clazz) {
        // first = clazz.newInstance();
        // last = clazz.newInstance();
        try {
            first = clazz.getDeclaredConstructor().newInstance();
            last = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    // T会被擦拭成Object，变成覆写，编译器会阻止一个实际上会变成覆写的泛型方法定义
    /*
     * public boolean equals(T t) {
     * return this == t;
     * }
     */
}
