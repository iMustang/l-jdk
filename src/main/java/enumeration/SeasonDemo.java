package enumeration;

/**
 * SeasonDemo
 * description:用季节展示枚举用法
 */

public class SeasonDemo {
	public static void main(String[] args) {
		Season spring = Season.SPRING;

		/**
		 * 0
		 * SPRING
		 * 春天
		 * 舒适宜人
		 */
		System.out.println(spring.ordinal());
		System.out.println(spring.name());
		System.out.println(spring.getTitle());
		System.out.println(spring.getDesc());
	}
}

enum Season {

	SPRING("春天", "舒适宜人"),
	SUMMER("夏天", "热情奔放"),
	AUTUMN("秋天", "收获累累"),
	WINTER("冬天", "一片苍茫");

	private String title;
	private String desc;

	Season(String title, String desc) {
		this.title = title;
		this.desc = desc;
	}

	public String getTitle() {
		return title;
	}

	public String getDesc() {
		return desc;
	}
}

