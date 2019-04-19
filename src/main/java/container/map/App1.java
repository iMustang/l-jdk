package container.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: App1
 * @Description: HashMap示例
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 10:25
 */
public class App1 {
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
