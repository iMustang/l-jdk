package multithread.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * SpinLock
 * 不可重入自旋锁实现
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/12 1:04 下午
 */
public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<Thread>();

    public void lock() {
        Thread current = Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }
}
