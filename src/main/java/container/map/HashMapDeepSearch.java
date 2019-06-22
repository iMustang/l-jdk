package container.map;

import java.util.HashMap;

/**
 * HashMap底层原理
 * 以JDK7实现为准
 */
public class HashMapDeepSearch {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static int hashSeed = 0;

    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>(-1);
        /**
         * 不指定参数，创建HashMap时，
         * DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
         * DEFAULT_LOAD_FACTOR = 0.75f;
         * 创建HashMap时，并不初始化内部table
         * table的每个位置存储的是Entry链
         */
        HashMap<String, String> map = new HashMap<>();

        // HashMap内部保存的是Entry（指代每一个key-value对）
        /**
         * static class Entry<K,V> implements Map.Entry<K,V>{
         *      final K key;
         *      V value;
         *      Entry<K,V> next;
         *      int hash;
         * }
         */

        // 首次使用时，初始化内部table，如put()
        map.put("capital", "北京");
        /**
         * public V put(K key, V value) {
         *     if (table == EMPTY_TABLE) {
         *         inflateTable(threshold);     // 创建table，inflateTable(int toSize)
         *                                      // capacity = roundUpToPowerOf2(toSize);
         *                                      // table = new Entry[capacity]; // 每次新建或扩展（resize）时，长度是2的幂
         *                                      // threshold = capacity * loadFactor
         *     }
         *
         *     if (key == null)
         *         return putForNullKey(value); // HashMap可以存储key为null的Entry
         *                                      // putForNullKey(V value)
         *                                      // for (Entry<K,V> e = table[0]; e != null; e = e.next)
         *                                      // addEntry(0, null, value, 0);
         *                                      // key为null的Entry存放在table[0]
         *                                      // hash = (null != key) ? hash(key) : 0;
         *                                      // null的哈希值会计算为0
         *
         *     int hash = hash(key);
         *     int i = indexFor(hash, table.length); // 根据哈希值计算索引时，使用的算法是：
         *                                           // indexFor(int h, int length)
         *                                           // return h & (length-1);  // 这样计算的原因是：
         *                                                                      // 创建table时，设置capacity为2的幂，如16
         *                                                                      // 16-1 = 15 = 1111(二进制）
         *                                                                      // h & (length-1)，按位与会确保散列均匀
         *                                                                      // 这样做，效果上等同于取模，提高了性能
         *
         *     for (Entry<K,V> e = table[i]; e != null; e = e.next) {  // 如果key已经存在，就替换旧值，并返回旧值，put()就此return
         *         Object k;
         *         if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
         *             V oldValue = e.value;
         *             e.value = value;
         *             e.recordAccess(this);
         *             return oldValue;
         *         }
         *     }
         *
         *     modCount++;
         *     addEntry(hash, key, value, i); // 如果key不存在，就添加新Entry
         *                                    // addEntry(int hash, K key, V value, int bucketIndex) {
         *                                    //    if ((size >= threshold) && (null != table[bucketIndex])) {
         *                                    //        resize(2 * table.length); // size（map中存储的key的个数）
         *                                                                        // threshold，每次新建或resize时，threshold = capacity * loadFactor
         *                                                                        // size超过threshold时，resize(2 * table.length)，重新计算各个Entry的哈希值
         *                                    //        hash = (null != key) ? hash(key) : 0;
         *                                    //        bucketIndex = indexFor(hash, table.length);
         *                                    //    }
         *                                    //    createEntry(hash, key, value, bucketIndex);
         *                                    // }
         *
         *
         *                                    // createEntry(int hash, K key, V value, int bucketIndex) {
         *                                    //    Entry<K,V> e = table[bucketIndex];
         *                                    //    table[bucketIndex] = new Entry<>(hash, key, value, e);
         *                                    //    size++;
         *                                    // }
         *                                    // 创建Entry插入时，使用头插法，发明者认为后插入的Entry被查找的可能性更大
         *                                    // Entry(int h, K k, V v, Entry<K,V> n) {
         *                                    //    value = v;
         *                                    //    next = n;   // 头插法
         *                                    //    key = k;
         *                                    //    hash = h;
         *                                    // }
         *     return null;
         * }
         */

        map.get("capital"); // public V get(Object key) {
        //      if (key == null)
        //          return getForNullKey();
        //      Entry<K,V> entry = getEntry(key);  // table中的每个元素都是一个Entry链，getEntry中遍历Entry链，寻找key
        //      return null == entry ? null : entry.getValue();
        // }

        // JDK7中找到2的幂的方法
        System.out.println("roundUpToPowerOf2(4):" + roundUpToPowerOf2(4));//4
        System.out.println("roundUpToPowerOf2(5):" + roundUpToPowerOf2(5));//8
        System.out.println("roundUpToPowerOf2(7):" + roundUpToPowerOf2(7));//8

        // JDK8中找到2的幂的方法
        System.out.println("tableSize(4):" + tableSizeFor(4));//4
        System.out.println("tableSize(5):" + tableSizeFor(5));//8
        System.out.println("tableSize(7):" + tableSizeFor(7));//8


        // MAXIMUM_CAPACITY = 1 << 30 = 2^30
        System.out.println(MAXIMUM_CAPACITY);
        System.out.println((int) Math.pow(2, 30));

        // 计算哈希值的方法
        String book = "book";
        int hash = hashInJDK7(book);
        System.out.println(hash);
        System.out.println(Integer.toBinaryString(hash));

        hash = hashInJDK8(book);
        System.out.println(hash);
        System.out.println(Integer.toBinaryString(hash));
    }

    // JDK7中HashMap类中的方法
    static int roundUpToPowerOf2(int number) {
        // assert number >= 0 : "number must be non-negative";
        return number >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
    }

    // JDK8中HashMap类中的方法
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    // JDK7中HashMap计算hash值
    static final int hashInJDK7(Object k) {
        int h = hashSeed;
        if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    // JDK8中HashMap计算hash值
    static final int hashInJDK8(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
