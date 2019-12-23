package basic.lambda;

/**
 * Converter
 *
 * @author xMustang
 * @since 1.0
 */
@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);
}
