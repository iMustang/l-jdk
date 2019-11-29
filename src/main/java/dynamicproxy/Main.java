package dynamicproxy;

import sun.misc.ProxyGenerator;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) throws IOException {
		// 需要代理的真实对象
		Subject target = new BeProxyedSubject();
		Subject subject = (Subject) Proxy.newProxyInstance(
				// 第一个参数是指定代理类的类加载器
				target.getClass().getClassLoader(),
				// 第二个参数是代理类需要实现的接口（传入被代理类实现的接口，这样生成的代理类和被代理类就实现了相同的接口）
				target.getClass().getInterfaces(),
				// 第三个参数是invocation handler，用来处理方法的调用。这里传入我们自己实现的handler
				new DynamicProxy(target));
		subject.rent();
		System.out.println(subject.getClass().getName());

		//下面是打印JVM生成的代理类
		byte[] classFile = ProxyGenerator.generateProxyClass(
				"$Proxy0",
				target.getClass().getInterfaces());
		File file = new File("F:/BeProxyedSubject.class");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		bos.write(classFile);
		bos.close();
	}
}