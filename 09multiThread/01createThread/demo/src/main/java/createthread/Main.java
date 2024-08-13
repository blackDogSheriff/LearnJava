package createthread;

public class Main {
    public static void main(String args[]) {
        // testCreate();

        System.out.println("main start ...");

        Thread t = new Thread(() -> {
            System.out.println("thread run");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("thread end.");
            }
        });
        t.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
        System.out.println("main end.");
    }

    public static void testCreate() {
        Thread t = new MyThread();
        t.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        Thread t3 = new Thread(() -> {
            System.out.println("Hello from lambda");
        });
        t3.start();
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from MyThread");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from MyRunnable");
    }
}

class Student {
    private String name;
    private String age;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }
}