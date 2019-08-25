package multithread.concurrentprogramming;

import java.util.concurrent.CountDownLatch;

/**
 * title: TestHarness
 * description: CountDownLatch两种常用用法
 */
public class TestHarness {
    public long timeTasks(int nThread, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThread);

        for (int i = 0; i < nThread; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();

                        }
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
