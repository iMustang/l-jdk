package jvm;

import java.util.ArrayList;

/**
 * @Title: HashMapTraverse
 * @Description: 提供JConsole观察内存监控使用，以64K/50ms的速度向Java堆中填充数据
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/22 13:42
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class JConsoleDemo1 {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}

