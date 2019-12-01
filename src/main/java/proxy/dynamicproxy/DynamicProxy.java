package proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
	//　这是需要被代理的真实对象
	private Object subject;

	public DynamicProxy(Object subject) {
		this.subject = subject;
	}

	@Override
	// 其中proxy在动态代理生成的代理类字节码中看到是this，也即是代理对象的实例
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		return method.invoke(subject, args);
	}

	private void before() {
		System.out.println("clean my room");
	}
}
