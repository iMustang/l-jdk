package jvm;

/**
 * 对象在finalize方法中逃出被回收
 */
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}

	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();

		// 对象第一次成功拯救自己
		SAVE_HOOK = null;
		System.gc();
		// finalize方法优先级低，暂停0.5s等待它执行
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			System.out.println("yes, i am still alive");
		} else {
			System.out.println("no, i am dead");
		}

		// 对象第二次自救失败
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			System.out.println("yes, i am still alive");
		} else {
			System.out.println("no, i am dead");
		}
	}
}
