package dead_lock;

public class Main {
    public static void main(String[] args) {
        var c1 = new Counter();
        c1.add(1);
        System.out.println(c1.get());
    }

}
