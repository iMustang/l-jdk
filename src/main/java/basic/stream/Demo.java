package basic.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Demo
 *
 * @author xMustang
 * @since 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("d");

        List<String> result = list.stream().filter(set::contains).collect(Collectors.toList());
        System.out.println(result);
    }
}
