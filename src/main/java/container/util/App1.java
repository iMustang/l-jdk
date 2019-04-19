package container.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @Title: App1
 * @Description: Collections工具类的示例
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 21:21
 */
public class App1 {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>();
        Integer[] moreInts = {6, 7, 8, 9};
        Collections.addAll(collection, moreInts);

    }
}
