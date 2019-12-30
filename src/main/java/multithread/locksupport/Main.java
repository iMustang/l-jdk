package multithread.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Main
 * LockSupport示例
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThread t1 = new ChangeObjectThread("t1");
        ChangeObjectThread t2 = new ChangeObjectThread("t2");
        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(5);
        t1.interrupt();

        LockSupport.unpark(t2);
        t2.join();

    }

    static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName() + "开始执行");
            LockSupport.park();
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(getName() + "被中断了");
            }
            System.out.println(getName() + "继续执行");
        }
    }
}
