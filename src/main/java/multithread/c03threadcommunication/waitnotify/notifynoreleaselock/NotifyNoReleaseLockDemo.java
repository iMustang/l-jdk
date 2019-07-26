package multithread.c03threadcommunication.waitnotify.notifynoreleaselock;

/**
 * NotifyNoReleaseLockDemo
 * description: notify()不释放锁
 */
public class NotifyNoReleaseLockDemo {
	public static void main(String[] args) {
		Object object = new Object();
		NotifyNoReleaseThread waitT1 = new NotifyNoReleaseThread(object, 1);
		NotifyNoReleaseThread notifyT1 = new NotifyNoReleaseThread(object, 2);
		NotifyNoReleaseThread notifyT2 = new NotifyNoReleaseThread(object, 2);
		waitT1.start();
		notifyT1.start();
		notifyT2.start();
	}
}
