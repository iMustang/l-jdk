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
	 * ThreadLocal
	 *     内部类：ThreadLocalMap
	 *         static class ThreadLocalMap {
	 *             int INITIAL_CAPACITY = 16;    // 初始长度为16
	 *             static class Entry extends WeakReference<ThreadLocal> {
	 *                 Object value;
	 *
	 *                 Entry(ThreadLocal k, Object v) {
	 *                     super(k);
	 *                     value = v;
	 *                 }
	 *             }
	 *         }
	 *
	 *     ThreadLocal ----> ThreadLocalMap<ThreadLocal,Object> <---- Thread
	 *
	 * set()
	 * 		public void set(T value) {
	 * 		    Thread t = Thread.currentThread();
	 * 		    ThreadLocalMap map = getMap(t);
	 * 		    if (map != null)
	 * 		        map.set(this, value);
	 * 		    else
	 * 		        createMap(t, value);
	 * 		}
	 *
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
	 *
	 * remove()
	 * 		public void remove() {
	 * 		     ThreadLocalMap m = getMap(Thread.currentThread());
	 * 		     if (m != null)
	 * 		         m.remove(this);
	 *      }
	 *
	 * ThreadLocalMap
	 *
	 *     static class ThreadLocalMap {
	 *         static class Entry extends WeakReference<ThreadLocal> {
	 *             Object value;
	 *
	 *             Entry(ThreadLocal k, Object v) {
	 *                 super(k);
	 *                 value = v;
	 *             }
	 *         }
	 *     }
	 *
	 *
	 *
	 */
}
