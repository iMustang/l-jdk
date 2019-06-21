package container.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name", "张三");
        linkedHashMap.put("address", "中国南京");
        linkedHashMap.put("country", "CN");
        // 取出的顺序与存储的顺序相同
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
