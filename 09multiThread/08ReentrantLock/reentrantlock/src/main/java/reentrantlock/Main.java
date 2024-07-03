package reentrantlock;
/*synchronized
- 锁很重
- 不会自动重试，而是等待notify
*/

public class Main {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        try {
            System.out.println("Hello world!");
            throwExceptions();
            return;
        } catch (Exception e) {
            System.out.println("Enter Exception");
            return;
        } finally {
            System.out.println("Enter finally");
        }



    }

    static void throwExceptions() {
        throw new IllegalStateException();
    }
}
