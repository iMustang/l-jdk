package container.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title: App2
 * @Description: LinkedHashMap示例
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 10:57
 */
public class App2 {
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
