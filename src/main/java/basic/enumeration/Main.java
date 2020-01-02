package basic.enumeration;

/**
 * Main
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        Season season = Season.getSeasonByOrder(1);
        System.out.println(season.getDesc());
    }
}
