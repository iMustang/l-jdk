package container.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Title: App7
 * @Description: toArray
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/19 22:42
 */
public class App7 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6);

        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
        Integer[] ia = new Integer[list.size()];
        list.toArray(ia);
        System.out.println(Arrays.toString(ia));
    }
}
