package typeerase;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*虚拟机将T认为是Object类型：
 * - 不可以使用基本类型：int之类
 * - 不能 getClass() ，因为获取的都是Pair<Object>类型
 * - 不能判断带泛型的类型例如：if (p instanceof Pair<String>){}
 * - 不能实例化T：例如new T()等操作
 */
public class Main {
    public static void main(String[] args) {
        // 编译器看到的代码：
        Pair<String> p = new Pair<>("Hello", "World");
        String first = p.getFirst();
        String last = p.getLast();

        // 泛型是在编译时实行的，编译器将T看作Object，需要转型的时候会根据T的类型进行安全的强制转换
        /*
         * 虚拟机处理的代码：
         * Pair p = new Pair("Hello", "World");
         * String first = (String)p.getFirst();
         * String last = (String)p.getLast();
         */

        // 局限一：<T>不能是基本类型（不能被Object持有）
        // Pair<int> p = new Pair<>(1,2); //编译错误

        // 局限二：不能获取带泛型的Class，获取的都是同一个Class（Pair<Object>）
        Pair<String> p1 = new Pair<>(first, last);
        Pair<Integer> p2 = new Pair<>(123, 456);
        System.out.println(p1.getClass() == p2.getClass());
        System.out.println(p1.getClass() == Pair.class);

        // 局限三：不能判断带泛型的类型
        Pair<Integer> p3 = new Pair<>(123, 456);
        // if (p instanceof Pair<String>) { }
        // //编译错误，不存在Pair<String>.class，只有唯一的Pair.class

        // 子类获取父类的泛型：
        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
            Type firstType = types[0]; // 取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // Integer
        }

    }
}

// 局限四：不能实例化T类型
/*
 * new T()，擦拭以后变成了new Obejct()；new Pair<String>()和new
 * Pair<Integer>()就全部变成了Object，编译器会阻止这种明显不正确的代码
 * 
 * public class Pair<T> {
 * private T first;
 * private T last;
 * 
 * public Pair() {
 * // Compile error:
 * first = new T();
 * last = new T();
 * }
 * }
 */
