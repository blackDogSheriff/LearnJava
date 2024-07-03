package stampedlock;

import java.util.concurrent.locks.StampedLock;

/*
 * StampedLock是不可重入锁，不能再同一个线程中重复获取锁
 */

public class Point {
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock(); // 获取写锁
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.writeLock();
        }
    }

    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead(); // 获取乐观读锁

        // 不是原子操作，可能在过程中被其它线程修改值
        double currentX = x;
        double currentY = y;

        if (!stampedLock.validate(stamp)) { // 检查获取乐观读锁之后是否有其它写锁发生
            stamp = stampedLock.readLock(); // 获取一个悲观读锁
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlock(stamp); // 释放悲观读锁
            }
        }

        return Math.sqrt(currentX * currentX + currentY * currentY);

    }

}
