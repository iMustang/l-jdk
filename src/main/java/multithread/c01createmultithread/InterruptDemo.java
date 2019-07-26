package multithread.c01createmultithread;

/**
 * InterruptDemo
 * description: interrupt()测试
 */
public class InterruptDemo extends Thread {
	public static void main(String[] args) {
		InterruptDemo interruptDemo = new InterruptDemo();
		interruptDemo.start();
		interruptDemo.interrupt();
		System.out.println("main线程已经发送过中断信号");
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
}
