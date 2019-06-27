package multithread.thisescape.thissafe;

import multithread.thisescape.EventListener;
import multithread.thisescape.EventSource;

/**
 * @Title: ThisSafe
 * <p>
 * <p>
 * 由内部类导致的this引用逸出，需要满足两个条件：
 * 一个是在构造函数中创建内部类(EventListener)，
 * 另一个是在构造函数中就把这个内部类给发布了出去(source.registerListener)。
 * <p>
 * 因此，我们要防止这一类this引用逸出的方法就是避免让这两个条件同时出现。也就是说，如果要在构造函数中创建内部类，那么就不能在构造函数中把他发布了，应该在构造函数外发布，即等构造函数执行完毕，初始化工作已全部完成，再发布内部类。
 * 如下面所示，使用一个私有的构造函数进行初始化和一个公共的工厂方法进行发布。
 *
 *
 * 另一种导致this引用逸出的常见错误，是在构造函数中启动一个线程。解决的办法也相似，即可在构造函数中创建线程，但别启动它。在构造函数外面再启动。
 *
 * 在构造函数中调用一个可改写的实例方法时（既不是私有方法，也不是final方法），同样会导致this引用在构造过程中逸出。
 *
 * 只有当构造函数返回时，this引用才应该从线程中逸出。构造函数可以将this引用保存到某个地方，只要其他线程不会再构造函数完成之前使用它。
 */
public class ThisSafe {

	public final int id;
	public final String name;
	private final EventListener listener;

	private ThisSafe() {
		id = 1;
		listener = new EventListener() {
			public void onEvent(Object obj) {
				System.out.println("id: " + ThisSafe.this.id);
				System.out.println("name: " + ThisSafe.this.name);
			}
		};
		name = "xmustang";
	}

	public static ThisSafe getInstance(EventSource<EventListener> source) {
		ThisSafe safe = new ThisSafe();
		source.registerListener(safe.listener);
		return safe;
	}

}
