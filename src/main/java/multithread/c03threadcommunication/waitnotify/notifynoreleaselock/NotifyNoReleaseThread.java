package multithread.c03threadcommunication.waitnotify.notifynoreleaselock;

/**
 * NotifyNoReleaseThread
 * description:
 */
public class NotifyNoReleaseThread extends Thread {
	private Object object;
	private int type;

	public NotifyNoReleaseThread(Object object, int type) {
		this.object = object;
		this.type = type;
	}

	@Override
	public void run() {
		if (type == 1) {
			waitMethod();
		}
		if (type == 2) {
			notifyMethod();
		}
	}

	public void waitMethod() {
		synchronized (object) {
			System.out.println(Thread.currentThread().getName() + " enter wait()");
			try {
				object.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " exit wait()");
		}
	}

	public void notifyMethod() {
		synchronized (object) {
			System.out.println(Thread.currentThread().getName() + " begin notify()");
			object.notify();
			// 如果notify释放锁，那么在这5s内必定应该改由其他线程进入同步代码块，运行结果，显示没有，所以notify不释放锁
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " exit notify()");
		}
	}
}
