package dead_lock;

public class Counter {
    private int count = 0;

    public int get() {
        return count;
    }

    public synchronized void add(int n) {
        if (n < 0) {
            // dec也要获取锁，JVM允许同一个线程重复获取同一个锁，这种叫可重入锁
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }
}
