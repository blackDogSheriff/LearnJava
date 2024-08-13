package threadsync;

public class Main {
    public static void main(String[] args) throws Exception {
        Thread t = new AddThread();
        Thread t2 = new DecThread();
        t.start();
        t2.start();
        t.join();
        t2.join();
        System.out.println(Counter.count);
    }
}
