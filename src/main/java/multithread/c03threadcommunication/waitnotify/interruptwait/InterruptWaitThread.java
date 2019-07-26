package multithread.c03threadcommunication.waitnotify.interruptwait;

/**
 * InterruptWaitThread
 * description:
 */
public class InterruptWaitThread extends Thread {
	private Object lock;

	public InterruptWaitThread(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println("enter wait()");
			try {
				lock.wait();
			} catch (InterruptedException e) {
				System.out.println("wait 被 interrupt() 打断了");
				e.printStackTrace();
			}
			System.out.println("exit wait()");
		}
	}
}
