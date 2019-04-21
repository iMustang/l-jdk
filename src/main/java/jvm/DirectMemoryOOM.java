package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Title: DirectMemoryOOM
 * @Description: 本机内存溢出
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/21 13:10
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
