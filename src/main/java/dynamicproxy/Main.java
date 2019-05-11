package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Title: cd
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/5/11 20:05
 */
public class Main {
    public static void main(String[] args) {
        // 我们要代理的真实对象
        Subject proxyedSubject = new BeProxyedSubject();
        InvocationHandler handler = new DynamicProxy(proxyedSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(
                proxyedSubject.getClass().getClassLoader(),
                proxyedSubject.getClass().getInterfaces(),
                handler);
        System.out.println(subject.getClass().getName());
        subject.rent();
    }
}