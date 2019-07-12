package enumeration;

/**
 * WeekDayEnum
 * description:
 * author: xMustang
 * version: 1.0
 * created: 2019/7/12 17:49
 */
public enum WeekDayEnum {
	MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);


	private int index;

	WeekDayEnum(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
