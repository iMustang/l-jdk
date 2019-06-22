package dynamicproxy;

import sun.misc.ProxyGenerator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public static void main(String[] args) throws IOException {
        // 需要代理的真实对象
        Subject proxyedSubject = new BeProxyedSubject();
        InvocationHandler handler = new DynamicProxy(proxyedSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(
                proxyedSubject.getClass().getClassLoader(),
                proxyedSubject.getClass().getInterfaces(),
                handler);
        System.out.println(subject.getClass().getName());
        subject.rent();

        //下面是打印JVM生成的代理类
        byte[] classFile = ProxyGenerator.generateProxyClass(
                "$Proxy0",
                proxyedSubject.getClass().getInterfaces());
        File file = new File("F:/BeProxyedSubject.class");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(classFile);
        bos.close();
    }
}