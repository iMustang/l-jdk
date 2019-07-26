package multithread.c03threadcommunication.waitnotify.waitreleaselock;


/**
 * WaitReleaseThread
 * description:
 */
public class WaitReleaseThread extends Thread {
	private Object object;

	public WaitReleaseThread(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		synchronized (object) {
			System.out.println(Thread.currentThread().getName() + " ：进入wait");
			try {
				object.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " ：退出wait");
		}
	}
}
