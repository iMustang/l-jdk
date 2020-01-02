package basic.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;


/**
 * Season
 *
 * @author xMustang
 * @since 1.0
 */
@Getter
public enum Season {
    SPRING(1, "春"),
    SUMMER(2, "夏"),
    AUTUMN(3, "秋"),
    WINTER(4, "冬");

    private static final Map<Integer, Season> SEASON_MAP = new HashMap<>();

    static {
        SEASON_MAP.put(SPRING.getOrder(), SPRING);
        SEASON_MAP.put(SUMMER.getOrder(), SUMMER);
        SEASON_MAP.put(AUTUMN.getOrder(), AUTUMN);
        SEASON_MAP.put(WINTER.getOrder(), WINTER);
    }

    public static Season getSeasonByOrder(Integer order) {
        return SEASON_MAP.get(order);
    }

    private final Integer order;
    private final String desc;

    Season(Integer order, String desc) {
        this.order = order;
        this.desc = desc;
    }
}
