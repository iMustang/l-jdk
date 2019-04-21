package container.collection.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Title: App5
 * @Description: Arrays.asList底层原理
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/19 13:53
 */
public class App5 {
    public static void main(String[] args) {
        Integer[] ia = {1, 2, 3, 4, 5, 6};
        List<Integer> integers = Arrays.asList(ia);
        System.out.println(integers);

        Collections.shuffle(integers);
        System.out.println(integers);

        // Arrays.asList底层使用了上面的ia数组，打乱后，底层ia数组也变化了
        System.out.println(Arrays.toString(ia));
    }

}
