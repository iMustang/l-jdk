package jvm;

/**
 * 大对象直接进入老年代
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreadhold=3145728
 */
public class PretenureSizeThreadhold {
	private static final int _1MB = 1024 * 1024;

	public static void testPretenureSizeThreadhold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB];
	}

	public static void main(String[] args) {
		testPretenureSizeThreadhold();
	}
}
