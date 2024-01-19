package com.bravo.pattern.proxy.register_dynamic_proxy.jdk.aop;

import com.bravo.pattern.proxy.metric.Metric;
import com.bravo.pattern.proxy.metric.MetricTagEnum;
import com.bravo.pattern.proxy.metric.MetricTagSetter;
import com.bravo.pattern.proxy.metric.MetricUtil2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

// 模拟Spring Aspect
public class JdkMetricAspect implements InvocationHandler {

    private final Object target;

    public JdkMetricAspect(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new JdkMetricAspect(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // JDK动态代理获取到的是接口方法，所以上面业务中我们只能把@Metric注解加到IUserService上
        Metric metric = method.getAnnotation(Metric.class);
        if (metric == null) {
            return method.invoke(target, args);
        }
        // 注意，原来的MetricUtil使用的是Supplier接口，不能声明异常。MetricUtil2替换为Callable接口
        return MetricUtil2.metric(() -> method.invoke(target, args), new MetricTagSetter<Object>() {
            @Override
            public void apply(Object result, Map<MetricTagEnum, String> initialTagMap) {
                initialTagMap.put(MetricTagEnum.BIZ_TAG, metric.bizTag());
                initialTagMap.put(MetricTagEnum.BIZ_SUB_TAG, metric.bizSubTag());
            }
        });
    }

}