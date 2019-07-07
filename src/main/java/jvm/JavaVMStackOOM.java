package jvm;

/**
 * 虚拟机栈和本地方法栈溢出，方式二：多线程
 */
public class JavaVMStackOOM {
	private void dontStop() {
		while (true) {

		}
	}

	private void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
