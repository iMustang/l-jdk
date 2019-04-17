package gather.collection.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Title: App1
 * @Description: ArrayList示例
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 0:22
 */
public class App1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

        for (String str : list) {
            System.out.println(str);

        }
    }
}
