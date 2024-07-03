package wrapper;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Callable<Long> callable = new Task(123450000L);
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();
    }
}