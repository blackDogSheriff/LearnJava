package typeerase;

/*
 * 在继承了泛型编程的情况下，子类可以获取到父类的泛型类型 T，也就是Integer
 */
public class IntPair extends Pair<Integer> {

    public IntPair(Class<Integer> clazz) {
        super(clazz);
    }
}

// 我们无法获取Pair<T>的T类型，即给定一个变量Pair<Integer> p，无法从p中获取到Integer类型
// 但是在父类是泛型类型的情况下，编译器会把类型T保存到子类的class文件中；