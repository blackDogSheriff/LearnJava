package wrapper;

import java.util.concurrent.Callable;

public class RunnableAdapter implements Runnable {
    private Callable<?> callable;

    // 构造方法
    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
