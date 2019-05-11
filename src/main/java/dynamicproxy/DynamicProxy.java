package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title: ds
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/5/11 20:04
 */
public class DynamicProxy implements InvocationHandler {
    //　这个就是我们要代理的真实对象
    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("clean my room");
        return method.invoke(subject, args);
    }
}
