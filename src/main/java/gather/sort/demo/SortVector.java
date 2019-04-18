package gather.sort.demo;

import java.util.Vector;

/**
 * @Title: SortVector
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 12:48
 */
public class SortVector extends Vector<String> {
    private Compare compare;

    public SortVector(Compare compare) {
        this.compare = compare;
    }

    public void sort() {
        quickSort(0, size() - 1);
    }

    private void quickSort(int left, int right) {
        if (right > left) {
            String rightLoc = elementAt(right);
            int i = left - 1;
            int j = right;
            while (true) {
                while (compare.lessThan(elementAt(++i), rightLoc)) {

                }
                while (j > 0) {
                    if (compare.lessThanOrEual(elementAt(--j), rightLoc)) {
                        break;
                    }
                }
                if (i >= j) {
                    break;
                }
                swap(i, j);
            }
            swap(i, right);
            quickSort(left, i - 1);
            quickSort(i + 1, right);

        }
    }

    private void swap(int loc1, int loc2) {
        String tmp = elementAt(loc1);
        setElementAt(elementAt(loc2), loc1);
        setElementAt(tmp, loc2);
    }
}
