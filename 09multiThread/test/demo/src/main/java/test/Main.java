package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        var q = new TaskQueue(); // 任务队列
        var ts = new ArrayList<Thread>();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String s = q.getTask();
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

        // 创建一个添加线程
        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String s = "t- " + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
            }
        });
        add.start();

        try {
            add.join();
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        for (Thread t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<String>();

    public synchronized void addTask(String s) {
        queue.add(s);
        this.notify();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }

        return queue.remove();
    }
}