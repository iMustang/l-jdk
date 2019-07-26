package multithread.c03threadcommunication.waitnotify.interruptwait;

/**
 * InterruptWaitDemo
 * description: interrupt 可以打断wait()
 */
public class InterruptWaitDemo {
	public static void main(String[] args) throws InterruptedException {
		InterruptWaitThread interruptWaitThread = new InterruptWaitThread(new Object());
		interruptWaitThread.start();
		Thread.sleep(5000);
		interruptWaitThread.interrupt();
	}
}
