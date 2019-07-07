package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM堆溢出：Java heap space
 */
public class HeapOOM {
	static class OOMObject {

	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		int i = 0;
		while (true) {
			i++;
			System.out.println(i);
			list.add(new OOMObject());
		}
	}
}
