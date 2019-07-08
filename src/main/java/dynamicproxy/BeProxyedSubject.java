package dynamicproxy;

public class BeProxyedSubject implements Subject {
	@Override
	public void rent() {
		System.out.println("rent my house");
	}
}