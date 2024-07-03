package reentrantlock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();

    private Queue<String> queue = new LinkedList<String>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                // 可以指定时间，如果时间到了之后还没有醒来，则执行其它操作
                /*
                 * if (cond.await(1, TimeUnit.SECONDS)) {
                 * // 执行任务
                 * } else {
                 * // 进行其它操作
                 * }
                 */
                cond.await(); // 释放当前锁，进入等待状态，返回后重新获取锁；

            }
            return queue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

}
