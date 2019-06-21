package container.map;

import java.util.HashMap;

/**
 * HashMap深入探究
 */
public class HashMapDeepSearch {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>(-1);

        System.out.println("tableSize(4):" + tableSizeFor(4));//4
        System.out.println("tableSize(5):" + tableSizeFor(5));//8
        System.out.println("tableSize(7):" + tableSizeFor(7));//8


        // MAXIMUM_CAPACITY = 1 << 30
        System.out.println(MAXIMUM_CAPACITY);
        System.out.println((int) Math.pow(2, 30));

        String book = "book";
        int hash = hash(book);
        System.out.println(hash);
        System.out.println(Integer.toBinaryString(hash));
    }

    // HashMap类中的方法
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    // HashMap类中的方法
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
