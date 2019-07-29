package multithread.c07lockobject.s02condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ConditionThread
 * description:
 */
public class ConditionThread extends Thread {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void askTowait() {
		try {
			lock.lock();
			System.out.println("wait时的时间：" + System.currentTimeMillis());

			condition.await();
			System.out.println("wait结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void sendWakeupMsg() {
		try {
			lock.lock();
			System.out.println("signal时的时间为：" + System.currentTimeMillis());
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void run() {
		askTowait();
	}
}
