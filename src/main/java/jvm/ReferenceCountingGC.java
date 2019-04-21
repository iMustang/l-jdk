package jvm;

/**
 * @Title: ReferenceCountingGC
 * @Description: 判断HotSpot是否采用引用计数算法判断对象已死
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/21 14:26
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();

    }
}
