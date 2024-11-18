package sync_method;

/*
 * 线程安全的类：
 * - 可以被多线程调用的类
 * - 不变类
 * - 只有静态方法的类
 */

public class Counter {
    private int count = 0;


    //直接锁实例
    //如果是静态方法，则锁定类的class
    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }
    //等价于直接锁定实例
    public synchronized void add1(int n){
        count +=n;
    }


    public void dec(int n) {
        synchronized (this) {
            count -= n;
        }
    }

    //只读不需要同步
    public int get() {
        return count;
    }

    //写一个线程安全的加法器
    
}
