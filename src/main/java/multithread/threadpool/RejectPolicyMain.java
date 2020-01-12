package multithread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * RejectPolicyMain
 * ThreadPoolExecutor.CallerRunsPolicy示例
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/12 12:10 下午
 */
public class RejectPolicyMain {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<>(10);
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ExecutorService threadPool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                workingQueue, rejectedExecutionHandler);

        for (int i = 0; i < 100; i++) {
            threadPool.submit(() -> {
                System.out.println("当前任务在线程" + Thread.currentThread().getName() + "中运行");
                Thread.sleep(1000);
                return true;
            });
        }
    }
}
