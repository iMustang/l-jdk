package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * PersonIntercept
 *
 * @author: xMustang
 * @since: 1.0
 */
public class PersonIntercept implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        begin();
        Object result = proxy.invokeSuper(obj, args);
        end();
        return result;
    }

    private void begin() {
        System.out.println("begin");
    }

    private void end() {
        System.out.println("end");
    }
}
