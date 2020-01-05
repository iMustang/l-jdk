package multithread.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * CyclicBarrierMain
 *
 * @author xMustang
 * @since 1.0
 */
public class CyclicBarrierMain {
    // 请求的数量
    private static final int threadCount = 550;
    // 需要同步的线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            TimeUnit.SECONDS.sleep(1);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadNum:" + threadNum + "is ready");
        cyclicBarrier.await();
        System.out.println("threadNum:" + threadNum + "is finish");
    }
}
