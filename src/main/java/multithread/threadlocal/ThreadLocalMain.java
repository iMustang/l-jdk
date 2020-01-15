package multithread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocalMain
 * ThreadLocal使用引用方式时的正确使用方式
 *
 * @author xMustang
 * @since 1.0
 */
public class ThreadLocalMain {
    private static final ThreadLocal<StringBuilder> BUIDER = ThreadLocal.withInitial(() ->
            new StringBuilder("init")
    );

    private static class AppendStringThread extends Thread {
        @Override
        public void run() {
            final StringBuilder inThread = BUIDER.get();
            for (int i = 0; i < 10; i++) {
                inThread.append("-").append(i);
                Thread.yield();
            }
            System.out.println(inThread.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new AppendStringThread().start();
        }
        TimeUnit.SECONDS.sleep(10);
    }
}
