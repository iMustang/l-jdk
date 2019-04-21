package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: HeapOOM
 * @Description: JVM堆溢出：Java heap space
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/21 11:10
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        int i = 0;
        while (true) {
            i++;
            System.out.println(i);
            list.add(new OOMObject());
        }
    }
}
