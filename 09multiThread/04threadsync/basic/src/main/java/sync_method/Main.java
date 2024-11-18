package sync_method;

public class Main {
    public static void main(String[] args) {
        var c1 = new Counter();

        Thread t1 = new Thread(() -> {
            c1.add(20);
        });
        Thread t2 = new Thread(() -> {
            c1.dec(10);
        });

        t1.start();
        t2.start();
        System.out.println(123);
    }
}
