package container.map;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap遍历
 */
public class HashMapTraverse {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "张三");
        hashMap.put("address", "中国南京");
        hashMap.put("address", "中国潍坊");
        hashMap.put("country", "CN");

        for (Map.Entry entry : hashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " : " + value);
        }

        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
