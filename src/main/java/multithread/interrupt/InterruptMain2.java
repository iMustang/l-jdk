package multithread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * InterruptMain2
 * 只是发送中断信号，线程不会被中断
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/12 11:09 上午
 */
public class InterruptMain2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "在运行");
                    Thread.yield();
                }
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
