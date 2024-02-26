package com.bravo.other.aop;


import lombok.Data;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 类似Filter模式中的FilterChain：将方法调用不断委托到下一个Interceptor
 */
@Data
public class ReflectiveMethodInvocation implements MethodInvocation {

    private final Object proxy;

    private final Object target;

    private final Method method;

    private final Object[] arguments;

    private final Class<?> targetClass;

    private final List<MethodInterceptor> interceptors;

    private int currentIndex = -1;

    public ReflectiveMethodInvocation(Object proxy, Object target, Method method, Object[] arguments,
                                      Class<?> targetClass, List<MethodInterceptor> interceptors) {
        this.proxy = proxy;
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.targetClass = targetClass;
        this.interceptors = interceptors;
    }

    @Override
    public Object proceed() throws Throwable {
        if (this.currentIndex == this.interceptors.size() - 1) {
            // 所有interceptor执行完毕，调用目标method
            return method.invoke(this.target, this.arguments);
        }

        // 逐个执行interceptor
        MethodInterceptor interceptor = this.interceptors.get(++this.currentIndex);
        return interceptor.invoke(this);
    }
}
