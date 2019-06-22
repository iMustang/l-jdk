package container.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "张三");
        treeMap.put(4, "李四");
        treeMap.put(2, "王五");

        // 存入时根据key进行排序，取出的顺序是经过排序的顺序
        for (Map.Entry entry : treeMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
