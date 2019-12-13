package container.map;

import com.sun.xml.internal.xsom.XSUnionSimpleType;

import java.util.HashMap;

/**
 * HashMapDemo
 *
 * @author: xMustang
 * @since: 1.0
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "a");
        map.put("b", null);
        System.out.println(map);

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("1","a");
        map2.put("1","b");// 此种key相等，是直接替换原来的元素。hash冲突是key的hash值相等，而key的value不相等。
        map2.put("1","c");
        System.out.println(map2.size());
        System.out.println(map2);
    }
}
