package multithread.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatchMain
 *
 * @author xMustang
 * @since 1.0
 */
public class CountDownLatchMain {
    // 请求的数量
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();// 表示一个请求已经被完成
                }

            });
        }
        threadPool.shutdown();
        countDownLatch.await();
        System.out.println("main线程开始后续操作");
        System.out.println("main线程后续操作完成");
    }

    public static void test(int threadNum) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);// 模拟请求的耗时操作
        System.out.println("threadNum:" + threadNum);
        TimeUnit.SECONDS.sleep(5);// 模拟请求的耗时操作
    }
}
