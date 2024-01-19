package com.bravo.pattern.proxy.register_dynamic_proxy.jdk.aop;

import com.bravo.pattern.proxy.metric.Metric;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

// 模拟Spring ApplicationContext
public class ApplicationContext {

    @SneakyThrows
    public Object getBean(String name) {
        // 根据全类名，得到目标类的Class对象
        Class<?> clazz = Class.forName(name);

        // 根据Class反射创建目标对象
        Object target = clazz.newInstance();

        // 判断目标对象是否需要代理
        if (this.needProxy(clazz)) {
            // 创建切面代理
            return JdkMetricAspect.createProxy(target);
        }
        return target;
    }

    private boolean needProxy(Class<?> clazz) {
        // 类上有无@Metric注解
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(Metric.class)) {
                return true;
            }
        }
        // 接口上有无@Metric注解
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> interfaceClazz : interfaces) {
            for (Method declaredMethod : interfaceClazz.getDeclaredMethods()) {
                if (declaredMethod.isAnnotationPresent(Metric.class)) {
                    return true;
                }
            }
        }
        return false;
    }

}