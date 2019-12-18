package basic.hash;

/**
 * Main
 *
 * @author: xMustang
 * @since: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = a;
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
