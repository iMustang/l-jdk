package multithread.c08customsynchronizer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * title: CountDownLatchDemo
 * description: 使用CountDownLatch示例
 */
public class CountDownLatchDemo {
    private final static int threadCount = 10;

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int finalI = i + 1;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    print(finalI);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有子线程执行完成");
        executorService.shutdown();

    }

    public static void print(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has printed，" + i);

    }
}
