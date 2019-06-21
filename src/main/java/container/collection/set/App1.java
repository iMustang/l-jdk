package container.collection.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Title: HashMapTraverse
 * @Description: HashSet示例
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 0:55
 */
public class App1 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("张三");
        hashSet.add("李四");
        hashSet.add("李四");
        hashSet.add("王五");

        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

        for (String str : hashSet) {
            System.out.println(str);
        }
    }
}
