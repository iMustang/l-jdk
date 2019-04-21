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
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
