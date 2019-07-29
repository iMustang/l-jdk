package multithread.c07lockobject.s02condition;

/**
 * ConditionThreadDemo
 * description:
 */
public class ConditionThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		ConditionThread conditionThread = new ConditionThread();

		conditionThread.start();

		Thread.sleep(3000);

		conditionThread.sendWakeupMsg();
	}
}
