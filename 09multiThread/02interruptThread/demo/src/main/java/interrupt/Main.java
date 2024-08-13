package interrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("main thread finished");
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread started");
        Thread thread = new HelloThread();
        thread.start();
        try {
            /*
             * run是立即返回的，因此join不会阻塞
             */
            thread.join(); // 等待
            System.out.println("HelloThread end");
        } catch (InterruptedException e) {
            System.out.println("thread received Interrupted");
        }
        System.out.println("MyThread end");
        thread.interrupt();
    }
}

class HelloThread extends Thread {
    public void run() {
        System.out.println("HelloThread started");
        int n = 0;
        while (!isInterrupted()) {
            System.out.println(n + " Hello");
            n++;
        }
    }
}