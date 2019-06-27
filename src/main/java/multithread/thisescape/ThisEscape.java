package multithread.thisescape;

/**
 * @Title: ThisEscape
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019-06-26 22:53
 */
public class ThisEscape {
	public final int id;
	public final String name;

	public ThisEscape(EventSource<EventListener> source) {
		id = 1;
		source.registerListener(new EventListener() {
			public void onEvent(Object obj) {
				System.out.println("id: " + ThisEscape.this.id);
				System.out.println("name: " + ThisEscape.this.name);
			}
		});
		// 使用耗时操作，模拟线程正好在构造函数未完成之前发生线程切换
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		name = "xmustang";
	}
}
