package syncfunc;

public class Counter {
    private int count = -1;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }

    // 用synchronized修饰的方法就是同步方法，它表示整个方法必须用this实例枷锁
    public synchronized void add1(int n) {
        count += n;
    }

    // 对于static方法，是没有this实例的，因为static方法针对类而不是实例，synchronized锁住的是该类的class实例
    public synchronized static void add2(int n) {
    }

    // 和上面等价
    public static void add3(int n) {
        synchronized (Counter.class) {
        }
    }

    public void dec(int n) {
        synchronized (this) {
            count -= n;
        }
    }

    public int get() {
        // 读一个int变量不需要同步
        return count;
    }
}