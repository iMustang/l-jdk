package multithread.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * SemaphoreMain
 * Semaphore使用示例
 * <p>
 * Semaphore经常用于限制获取某种资源的线程数量。
 *
 * @author xMustang
 * @since 1.0
 */
public class SemaphoreMain {
    // 请求的数量
    private static final int THREAD_COUNT = 550;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        // 一次只能允许执行的线程数量。
        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    semaphore.acquire();// 获取一个许可，所以可运行线程数量为20/1=20
                    test(threadNum);
                    semaphore.release();// 释放一个许可

//                    semaphore.acquire(5);// 获取5个许可，所以可运行线程数量为20/5=4
//                    test(threadNum);
//                    semaphore.release(5);// 获取5个许可，所以可运行线程数量为20/5=4
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);// 模拟请求的耗时操作
        System.out.println("threadNum:" + threadNum);
        TimeUnit.SECONDS.sleep(5);// 模拟请求的耗时操作
    }
}
