package gather.sort.demo;

/**
 * @Title: StringCompare
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 12:49
 */
public class StringCompare implements Compare<String> {

    @Override
    public boolean lessThan(String lhs, String rhs) {
        return lhs.toLowerCase().compareTo(rhs.toLowerCase()) < 0;
    }

    @Override
    public boolean lessThanOrEual(String lhs, String rhs) {
        return lhs.toLowerCase().compareTo(rhs.toLowerCase()) <= 0;
    }
}
