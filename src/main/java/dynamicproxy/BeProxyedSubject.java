package dynamicproxy;

/**
 * @Title: ds
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/5/11 20:04
 */
public class BeProxyedSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("rent my house");
    }
}