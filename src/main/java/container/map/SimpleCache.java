package container.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * SimpleCache
 * 使用LinkedHashMao构造缓存
 * <p>
 * 缓存策略：
 * 在构造缓存对象时，传入最大节点数。当插入的节点数超过最大节点数时，移除最近最少被访问的节点。
 *
 * @author xMustang
 * @since 1.0
 */
public class SimpleCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_NODE_NUM = 100;

    private int limit;

    public SimpleCache() {
        this(MAX_NODE_NUM);
    }

    SimpleCache(int limit) {
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    public V save(K key, V value) {
        return put(key, value);
    }

    public V getOne(K key) {
        return get(key);
    }

    public boolean contains(K key) {
        return containsKey(key);
    }

    /**
     * 判断节点数是否超限
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }

    public static void main(String[] args) {
        SimpleCache<Integer, Integer> cache = new SimpleCache<>(3);

        for (int i = 0; i < 10; i++) {
            cache.save(i, i * i);
        }

        System.out.println("插入10个键值对后，缓存内容：");
        System.out.println(cache + "\n");

        System.out.println("访问键值为7的节点后，缓存内容：");
        cache.getOne(7);
        System.out.println(cache + "\n");

        // 然后通过访问键值为7的节点，使得该节点被移到双向链表的最后位置。当我们再次插入一个键值对时，键值为7的节点就不会被移除。
        System.out.println("插入键值为1的键值对后，缓存内容：");
        cache.save(1, 1);
        System.out.println(cache);
    }
}
