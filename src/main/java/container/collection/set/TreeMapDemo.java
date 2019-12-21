package container.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Title: TreeMapDemo
 * @Description: TreeSet示例
 * @author xMustang
 * @Version: 1.0
 * @create: 2019/4/18 1:13
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(8);
        treeSet.add(4);
        treeSet.add(9);
        treeSet.add(3);

        Iterator<Integer> it = treeSet.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            System.out.println(next);
        }
    }
}
