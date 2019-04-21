package container.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title: App6
 * @Description: ArrayList.subList，并没有重新拷贝一份list
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/19 22:37
 */
public class App6 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6);

        System.out.println("原List：" + list);
        List<Integer> subList = list.subList(2, 5);
        System.out.println("原subList：" + subList);

        Collections.shuffle(list);
        System.out.println("打乱后的List：" + list);
        System.out.println("打乱后的subList：" + subList);

        Collections.sort(list);
        System.out.println("排序后的List：" + list);

    }
}
