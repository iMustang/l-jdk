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
	 * 声明一个ThreadLocal对象tl后，其他线程是内部的ThreadLocalMap使用这个共用的tl作为key，value是在其他线程内自己维护的值。
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
	 * 内存泄漏：https://www.jianshu.com/p/a1cd61fa22da
	 *     如果外部的ThreadLocal实例tl是非static的，那么tl设置为null时，意味着对象为垃圾对象，而其他线程的ThreadLocalMap对象tlm使用这个tl时，是弱引用，因此垃圾回收器这时可以回收这个tl对象，相应地，tlm中原来引用这个tl对象的key会变为null，但是value是强引用，不会被回收，造成内存泄漏
	 *     如果外部的ThreadLocal实例tl是static的，那么其他线程的ThreadLocalMap对象tlm使用这个tl为key时，如果value特别大，而且该线程周期长，那么value长时间得不到回收，可能会造成内存溢出。
	 *     解决内存泄漏，对于tlm中引用static的tl，使用完后，调用remove()删除这个key。另外get()、set()、remove()每次调用时都会删除tlm中所有key为null的Entry，释放value。
	 *
	 * ThreadLocalMap使用开放地址法解决哈希冲突
	 *     https://www.jianshu.com/p/56f64e3c1b6c
	 *
	 */
}
