package sync_method;

/*
 * 线程安全的类：
 * - 可以被多线程调用的类
 */

public class Counter {
    private int count = 0;


    //直接锁实例
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

    public int get() {
        return count;
    }

}
