package wait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        var q = new TaskQueue();
        var ts = new ArrayList<Thread>();

        // 创建消费线程
        for (int i = 0; i < 5; i++) {
            var t = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String s = q.getTask1();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };

            t.start();
            ts.add(t);
        }

        // 创建生产线程
        var add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String s = "t- " + Math.random();
                System.out.println("add task:" + s);
                q.addTask1(s);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("1111");
                }
            }
        });
        add.start();
        try {
            add.join();
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        for (var t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
    }

    public synchronized void addTask1(String s) {
        this.queue.add(s);
        this.notifyAll(); // 唤醒在this上面等待的线程
    }

    public synchronized String geTask() {
        while (queue.isEmpty()) { // while循环永远不会退出，其它线程无法获得锁
        }
        return queue.remove();
    }

    public synchronized String getTask1() throws InterruptedException {
        while (queue.isEmpty()) {
            // wait会释放线程获取的锁，wait返回之后又会重新获取锁
            this.wait(); // wait必须在当前获取锁的对象上调用，这里获取的是this锁
        }
        return queue.remove();
    }
}