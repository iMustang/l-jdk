package container.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashDemo
 *
 * @author xMustang
 * @since 1.0
 */
public class ConcurrentHashDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "A");
        map.put("b", "B");
    }
}
