package multithread.c08customsynchronizer;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * title: CyclicBarrierDemo
 * description: CyclicBarrier 允许一组线程相互等待，直到到达某个公共屏障点（common barrier point）。通过它可以完成多个线程之间相互等待，只有当每个线程都准备就绪后，才能各自继续往下执行后面的操作。
 */
public class CyclicBarrierDemo {
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i + 1;
            Thread.sleep(1000);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        race(threadNum);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println(threadNum + " is ready");
        barrier.await();
        System.out.println(threadNum + " continue");
    }
}
