package jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * JConsole演示线程死循环、线程死锁
 */
public class JConsoleDemo2 {
	/**
	 * 线程死循环演示
	 */
	private static void createBusyThread() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) ;
			}
		}, "testBusyThread");
		thread.start();
	}

	/**
	 * 线程锁等待演示
	 *
	 * @param lock
	 */
	private static void createLockThread(final Object lock) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "testLockThread");
		thread.start();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		createBusyThread();
		br.readLine();
		Object obj = new Object();
		createLockThread(obj);
	}
}
