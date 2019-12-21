package basic.packing;

/**
 * Main
 * 包装类型在[-128,127]之间使用缓存
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        Byte a1 = 4;
        Byte a2 = 4;
        System.out.println(a1 == a2);

        Short b1 = 4;
        Short b2 = 4;
        System.out.println(b1 == b2);

        Character c1 = 4;
        Character c2 = 4;
        System.out.println(c1 == c2);

        Integer d1 = 4;
        Integer d2 = 4;
        System.out.println(d1 == d2);

        Long e1 = 4L;
        Long e2 = 4L;
        System.out.println(e1 == e2);

        Boolean f1 = true;
        Boolean f2 = true;
        System.out.println(f1 == f2);

        Integer g1 = Integer.valueOf(137);
        Integer g2 = Integer.valueOf(137);
        System.out.println(g1 == g2);

        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        System.out.println(i4 == (i5 + i6));
    }
}
