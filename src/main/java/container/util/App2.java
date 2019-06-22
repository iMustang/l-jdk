package container.util;

import java.util.Arrays;
import java.util.List;

/**
 * @Title: LinkedHashMapDemo
 * @Description: Arrays工具类的示例
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 21:31
 */
public class App2 {
    public static void main(String[] args) {
        Integer[] moreInts = {4, 5, 6, 7};
        // 返回的是Arrays的内部类ArrayList
        List<Integer> list = Arrays.asList(moreInts);

        list.set(2, 90);
        System.out.println(list);
        // Arrays的内部类ArrayList，使用数组实现，添加值会引发异常。
        // 下面代码报UnsupportedOperationException
//        list.add(12);
    }
}