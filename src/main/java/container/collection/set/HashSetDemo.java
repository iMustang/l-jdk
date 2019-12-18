package container.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSetDemo
 *
 * @author: xMustang
 * @since: 1.0
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("c");
        set.add("b");
        set.add("a");
        set.add("b");

        set.remove("c");
        boolean contains = set.contains("a");
        System.out.println(contains);

        for (String tmp : set) {
            System.out.println(tmp);
        }

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

        ArrayList<String> list = new ArrayList<>(set);
        boolean contains1 = list.contains("a");

        HashSet<String> set1 = new HashSet<>(list);
        boolean c = set1.contains("c");
    }
}
