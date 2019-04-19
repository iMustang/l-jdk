package container.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title: App5
 * @Description: 测试list.suList并不是创建新的list
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 22:23
 */
public class App5 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "d", "e", "f", "g", "h");
        System.out.println("初始list：" + list);
        List<String> subList = list.subList(3, 5);
        System.out.println("子list：" + subList);

        Collections.shuffle(list);
        System.out.println("打乱后list：" + list);
        System.out.println("打乱后子list：" + subList);

    }
}
