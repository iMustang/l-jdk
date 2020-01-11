package multithread.concurrentcollection.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Producer
 *
 * @author xMustang
 * @since 1.0
 */
public class Producer implements Runnable {
    protected BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("1");
            TimeUnit.SECONDS.sleep(1);
            queue.put("2");
            TimeUnit.SECONDS.sleep(1);
            queue.put("3");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
