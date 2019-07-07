package jvm;

/**
 * 虚拟机栈和本地方法栈溢出，方式一：减少栈内存容量。
 */
public class JavaVMStackSOF {
	private int stackLength = 1;

	private void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length:" + oom.stackLength);
			throw e;
		}
	}
}
