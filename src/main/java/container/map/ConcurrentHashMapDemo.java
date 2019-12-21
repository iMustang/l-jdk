package container.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMapDemo
 * <p>
 * ConcurrentHashMap的Key、Value不能为null
 *
 * @author xMustang
 * @since 1.0
 */
public class ConcurrentHashMapDemo {
	public static void main(String[] args) {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		map.put(null, "1");
		System.out.println(map);
	}
}
