package gather.collection.list;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Title: App4
 * @Description: Vector示例
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 0:51
 */
public class App4 {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("a");
        vector.add("b");
        vector.add("c");

        Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }
}
