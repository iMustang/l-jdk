package multithread;

/**
 * ThreadLocalDeepResearch
 * description:ThreadLocal深入探究
 */
public class ThreadLocalDeepResearch {
	/**
	 * 在Thread类中有属性：
	 * ThreadLocal.ThreadLocalMap threadLocals = null;
	 * 该属性的注释为：
	 * ThreadLocal values pertaining to this thread. This map is maintained by the ThreadLocal class.
	 * ThreadLocal的值归属于此线程，这个map由ThreadLocal类维护
	 *
	 * ThreadLocal类：
	 * get()
	 * 		public T get() {
	 * 		    Thread t = Thread.currentThread();
	 * 		    ThreadLocalMap map = getMap(t);   // 获取当前线程的ThreadLocalMap
	 * 		    if (map != null) {
	 * 		        ThreadLocalMap.Entry e = map.getEntry(this);
	 * 		        if (e != null)
	 * 		            return (T)e.value;
	 * 		    }
	 * 		    return setInitialValue();
	 * 		}
	 */
}
