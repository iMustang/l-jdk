package regular;

import java.util.regex.Pattern;

/**
 * @Title: TreeMapDemo
 * @Description: 专门测试正则限定符*、+、?
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/9 21:00
 */
public class App3 {
    public static void main(String[] args) {
        String pattern = "zo*";
        String testStr11 = "z";
        String testStr12 = "zo";
        String testStr13 = "zoo";
        System.out.println("zo*检验z：" + Pattern.matches(pattern, testStr11));
        System.out.println("zo*检验zo：" + Pattern.matches(pattern, testStr12));
        System.out.println("zo*检验zoo：" + Pattern.matches(pattern, testStr13));

        String pattern2 = "zo+";
        String testStr21 = "z";
        String testStr22 = "zo";
        String testStr23 = "zoo";
        System.out.println("zo+检验z：" + Pattern.matches(pattern2, testStr21));
        System.out.println("zo+检验zo：" + Pattern.matches(pattern2, testStr22));
        System.out.println("zo+检验zoo：" + Pattern.matches(pattern2, testStr23));

        String pattern3 = "zo?";
        String testStr31 = "z";
        String testStr32 = "zo";
        String testStr33 = "zoo";
        System.out.println("zo?检验z：" + Pattern.matches(pattern3, testStr31));
        System.out.println("zo?检验zo：" + Pattern.matches(pattern3, testStr32));
        System.out.println("zo?检验zoo：" + Pattern.matches(pattern3, testStr33));

        boolean matches = Pattern.matches("\\B-\\B", "a-b");
        System.out.println(matches + "fdsaf");
    }
}
