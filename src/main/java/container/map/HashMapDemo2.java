package container.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMapDemo2
 *
 * @author: xMustang
 * @since: 1.0
 */
public class HashMapDemo2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("c", 3);
        map.put("d", 4);

        // key-value，键值对
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            Integer value = map.get(key);
            System.out.println("key:" + key + "，value:" + value);
        }

        Collection<Integer> values = map.values();
        for (Integer integer : values) {
            System.out.println(integer);
        }

        boolean empty = map.isEmpty();
//        map.clear();
        map.containsKey("a");

        boolean b = map.containsValue(1);
    }
}
