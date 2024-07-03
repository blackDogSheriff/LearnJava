package createthread;

public class Main {
    public static void main(String[] args) {

        // 方法一：创建线程实例
        Thread t = new MyThread();
        t.start();

        // 方法二：传入runnable实例
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // 使用lambda简写方法二：
        Thread t3 = new Thread(() -> {
            System.out.println("Start a new thread");
        });
        t3.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Start new thread");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Start new thread");
    }
}
