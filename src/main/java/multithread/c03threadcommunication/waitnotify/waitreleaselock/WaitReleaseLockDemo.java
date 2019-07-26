package multithread.c03threadcommunication.waitnotify.waitreleaselock;

/**
 * WaitReleaseLockDemo
 * description: wait()释放锁
 */
public class WaitReleaseLockDemo {
	public static void main(String[] args) {
		Object obj = new Object();
		WaitReleaseThread thread1 = new WaitReleaseThread(obj);
		thread1.start();

		WaitReleaseThread thread2 = new WaitReleaseThread(obj);
		thread2.start();
	}
}
