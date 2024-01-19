package com.bravo.pattern.proxy.register_dynamic_proxy.cglib.aop;

import com.bravo.pattern.proxy.metric.Metric;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class ApplicationContext {

    @SneakyThrows
    public Object getBean(String name) {
        Class<?> clazz = Class.forName(name);

        Object target = clazz.newInstance();

        if (this.needProxy(clazz)) {
            // 注意，这里替换成CglibMetricAspect
            return CglibMetricAspect.createProxy(target);
        }
        return target;
    }

    private boolean needProxy(Class<?> clazz) {
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(Metric.class)) {
                return true;
            }
        }
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
