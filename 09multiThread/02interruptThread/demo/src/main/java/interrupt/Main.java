package interrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(10);
        t.interrupt();
        t.join();
        System.out.println("main thread finished");
    }
}

class MyThread extends Thread {
    // 接受到了interrupt后，立刻结束run
    public void run() {
        System.out.println("MyThread started");
        Thread thread = new HelloThread();
        thread.start();
        try {
            /*
             * 阻塞等待被调用线程结束
             * 如果调用线程接收到了Interrupt，则抛出InterruptedException
             */
            thread.join(); // 等待
        } catch (InterruptedException e) {
            System.out.println("Mythread received Interrupted");
        }
        System.out.println("MyThread end");
        thread.interrupt();
    }
}

class HelloThread extends Thread {
    //接收到了Interrupt的现线程，立刻结束run()方法
    public void run() {
        System.out.println("HelloThread started");
        int n = 0;
        while (!isInterrupted()) {
            System.out.println(n + " Hello");
            n++;
        }

        System.out.println("thread received Interrupted");
    }
}