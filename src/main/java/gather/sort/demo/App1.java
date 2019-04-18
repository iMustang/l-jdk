package gather.sort.demo;

import java.util.Enumeration;

/**
 * @Title: App1
 * @Description: 演示使用Vector实现排序算法
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 12:47
 */
public class App1 {
    public static void main(String[] args) {
        SortVector vector = new SortVector(new StringCompare());
        vector.addElement("d");
        vector.addElement("A");
        vector.addElement("c");
        vector.addElement("C");
        vector.addElement("B");
        vector.addElement("b");
        vector.addElement("a");

        vector.sort();

        Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }
}
