package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: RuntimeConstantPoolOOM
 * @Description: 运行时常量池溢出，需要在JDK1.6测试
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/21 12:41
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
