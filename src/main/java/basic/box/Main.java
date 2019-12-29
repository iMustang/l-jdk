package basic.box;

/**
 * Main
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        Integer i1 = new Integer(20);
        Integer i2 = new Integer(0);

        Integer i3 = new Integer(20);

        /**
         * i1 + i2 == i3，因为+这个操作符不适用于Integer对象，首先i1和i2进行自动拆箱操作，
         * 进行数值相加，即 20 == i3。然后Integer对象无法与数值进行直接比较，所以i3自动拆箱转为int值20，
         * 最终这条语句转为20 == 20进行数值比较。
         */
        System.out.println(i1 + i2 == i3);
    }
}
