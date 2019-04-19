package container.sort.demo;

/**
 * @Title: Compare
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 12:49
 */
public interface Compare<T> {
    boolean lessThan(T lhs, T rhs);

    boolean lessThanOrEual(T lhs, T rhs);
}
