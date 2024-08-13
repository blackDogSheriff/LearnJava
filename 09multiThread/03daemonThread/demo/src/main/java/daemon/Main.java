package daemon;

import java.time.LocalTime;

/*
 * 守护线程：为其它线程服务的线程
 * - 所有非守护线程结束之后，虚拟机自动结束，无论有没有守护线程
 * - 因此守护线程不能持有任何需要关闭的资源，例如打开的文件；
 */
public class Main {
    public static void main(String[] args) {
        Thread t = new TimerThread()
        ;
        t.setDaemon(true);
        t.start();
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}