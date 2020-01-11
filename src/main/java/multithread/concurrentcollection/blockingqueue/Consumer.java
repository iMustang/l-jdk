package multithread.concurrentcollection.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Consumer
 *
 * @author xMustang
 * @since 1.0
 */
public class Consumer implements Runnable {
    protected BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
