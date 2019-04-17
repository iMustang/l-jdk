package generic;

import java.util.ArrayList;

/**
 * @Title: App1
 * @Description: 泛型擦除
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 10:50
 */
public class App1 {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();

        Class aClass = strList.getClass();
        Class bClass = intList.getClass();
        boolean result = aClass.equals(bClass);
        System.out.println(result);
    }
}
