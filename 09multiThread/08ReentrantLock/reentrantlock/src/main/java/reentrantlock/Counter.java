package reentrantlock;

/*
 * synchronized implementation
 */

public class Counter {
    private int count;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }
}
