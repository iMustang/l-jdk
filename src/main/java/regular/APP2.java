package regular;

import java.util.regex.Pattern;

/**
 * @Title: APP2
 * @Description: 正则表达式匹配测试2
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/9 20:00
 */
public class APP2 {
    public static void main(String[] args) {
        String regex = "a{2}";
        String testStr = "aa";
        String testStr2 = "aaa";
        boolean matches = Pattern.matches(regex, testStr);
        System.out.println(matches);
        matches = Pattern.matches(regex, testStr2);
        System.out.println(matches);
    }
}
