package multithread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicIntegerArrayTest
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/12 2:09 下午
 */
public class AtomicIntegerArrayTest {
    public static void main(String[] args) {
        int temvalue;
        int[] nums = {1, 2, 3, 4, 5, 6};
        AtomicIntegerArray atArr = new AtomicIntegerArray(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.println(atArr.get(j));
        }
        temvalue = atArr.getAndSet(0, 2);
        System.out.println("temvalue:" + temvalue + ";  atArr:" + atArr);
        temvalue = atArr.getAndIncrement(0);
        System.out.println("temvalue:" + temvalue + ";  atArr:" + atArr);
        temvalue = atArr.getAndAdd(0, 5);
        System.out.println("temvalue:" + temvalue + ";  atArr:" + atArr);
    }
}
