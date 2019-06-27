package multithread.thisescape;

/**
 * ThisEscape
 */
class ThisEscape {
	private final int id;
	private final String name;

	ThisEscape(EventSource<EventListener> source) throws InterruptedException {
		id = 1;
		source.registerListener(new EventListener() {
			public void onEvent(Object obj) {
				System.out.println("id: " + ThisEscape.this.id);
				System.out.println("name: " + ThisEscape.this.name);
			}
		});
		// 使用耗时操作，模拟线程正好在构造函数未完成之前发生线程切换
		Thread.sleep(1000);
		name = "xmustang";
	}
}
