package basic.foreach;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Main
 * <p>
 * Java8 forEach示例
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};

        List<String> strList = Arrays.asList(arr);

        strList.forEach(System.out::println);

        HashSet<String> set = new HashSet<>(strList);
        set.forEach(System.out::println);

        ArrayDeque<String> queue = new ArrayDeque<>(strList);
        queue.forEach(System.out::println);

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.forEach((key, value) -> System.out.println(key + ":" + value));
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

    }
}
