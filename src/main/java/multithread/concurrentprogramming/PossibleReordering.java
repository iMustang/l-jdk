package multithread.concurrentprogramming;

/**
 * PossibleReordering
 * description:
 */
public class PossibleReordering {
	static int x = 0, y = 0;
	static int a = 0, b = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				a = 1;
				x = b;
			}
		});
		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				b = 1;
				y = a;
			}
		});
		A.start();
		B.start();

		A.join();
		B.join();

		System.out.println("x: " + x + ",y: " + y);
	}
}