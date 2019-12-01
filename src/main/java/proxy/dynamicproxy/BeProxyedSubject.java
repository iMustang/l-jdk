package proxy.dynamicproxy;

/**
 * 需要代理的真实对象
 */
public class BeProxyedSubject implements Subject {
	@Override
	public void rent() {
		System.out.println("rent my house");
	}
}