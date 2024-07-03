package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Add {
    private final Lock lock = new ReentrantLock();

    private int count;

    public void add(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }

    public void add1(int n) {
        try {
            // 尝试获取锁，如果1秒后仍然没有获取，trylock()就会返回false；
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    count += n;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
