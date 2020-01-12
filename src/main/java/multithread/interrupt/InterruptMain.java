package multithread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * InterruptMain
 * 中断线程的测试
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/12 11:03 上午
 */
public class InterruptMain {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(4);
        t.interrupt();
        TimeUnit.SECONDS.sleep(4);
    }
}
