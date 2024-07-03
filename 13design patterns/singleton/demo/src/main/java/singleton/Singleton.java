package main.java.singleton;

/*
 * 单例模式：保证一个类有且只有一个实例，并且提供一个访问它的全局点
 */
public class Singleton {
    // 全局唯一，static，final，private
    private static final Singleton INSTANCE = new Singleton();

    // private构造方法，保证调用方自己创建实例
    private Singleton() {
    }

    // 提供静态方法返回实例
    // public static final Singleton INSTANCE = new Singleton(); //直接将变量暴露在外部
    public static Singleton getInstance() { // 提供静态方法返回实例
        return INSTANCE;
    }

}
