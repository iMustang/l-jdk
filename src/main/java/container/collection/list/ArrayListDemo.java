package container.collection.list;

import java.util.*;

/**
 * ArrayListDemo
 *
 * @author: xMustang
 * @since: 1.0
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.set(2, "d");
        list.remove("c");

        boolean contains = list.contains("a");
        System.out.println(contains);

        System.out.println(list.isEmpty());

        System.out.println(list.indexOf("b"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String tmp : list) {
            System.out.println(tmp);
        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

        ArrayList<String> strings = new ArrayList<>(100);

        ArrayList<String> strings1 = new ArrayList<>(list);
        System.out.println(strings1);

        Object[] arr = list.toArray();
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));


        list.clear();


        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(34);
        integers.add(23);
        integers.add(13);
        System.out.println(integers);

        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(integers);

        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(2);
        integers1.add(1);
        integers1.add(1);
        System.out.println(integers1);

        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(1);
        System.out.println(set);

    }
}
