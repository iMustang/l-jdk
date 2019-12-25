package basic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * App
 * .collect
 *
 * @author xMustang
 * @version 1.0
 * @since 1.0
 */
public class App {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c"};
        List<String> list = Arrays.stream(str).collect(Collectors.toList());
        System.out.println(list);

        Set<String> set = Arrays.stream(str).collect(Collectors.toSet());
        System.out.println(set);
    }
}
