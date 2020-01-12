package multithread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * InterruptMain3
 * 响应线程中断信号
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/12 11:11 上午
 */
public class InterruptMain3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + "被中断");
                        return;
                    }
                }
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(2);
        t.interrupt();
    }
}
