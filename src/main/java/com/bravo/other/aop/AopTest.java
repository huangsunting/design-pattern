package com.bravo.other.aop;


import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 简易AOP
 * 完整的AOP有一个advisor的概念，advisor=advice+pointcut，advice代表具体的增强逻辑，pointcut代表匹配规则。
 * 比如 execution(* com.bravo.test.service.UserService.sayHello(..))，匹配规则的方法才进行增强。
 * 在当前案例中，手动传入增强逻辑，不支持匹配。
 */
public class AopTest {

    @Test
    public void test() {
        // 这是增强逻辑
        List<MethodInterceptor> chain = buildInterceptorChain();
        // 这是目标对象
        UserServiceImpl userService = new UserServiceImpl();
        // 对目标对象进行增强，得到代理对象
        UserService proxy = (UserService) getProxy(userService, chain);

        proxy.sayHello();
    }

    private Object getProxy(Object target, List<MethodInterceptor> chain) {
        return Proxy.newProxyInstance(AopTest.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Class<?> targetClass = target.getClass();
                if (chain == null || chain.isEmpty()) {
                    // 没有拦截器链，直接执行目标方法
                    return method.invoke(target, args);
                } else {
                    // method+interceptors，组成MethodInvocation，调用目标方法前执行interceptor
                    MethodInvocation invocation = new ReflectiveMethodInvocation(proxy, target, method, args, targetClass, chain);
                    return invocation.proceed();
                }
            }
        });
    }

    private List<MethodInterceptor> buildInterceptorChain() {
        List<MethodInterceptor> chain = new ArrayList<>();
        chain.add(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("方法执行前1");
                return invocation.proceed();
            }
        });
        chain.add(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("方法执行前2");
                return invocation.proceed();
            }
        });
        chain.add(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Object ret = invocation.proceed();
                System.out.println("方法执行后1");
                return ret;
            }
        });
        chain.add(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Object ret = invocation.proceed();
                System.out.println("方法执行后2");
                return ret;
            }
        });
        return chain;
    }

    interface UserService {
        void sayHello();
    }

    static class UserServiceImpl implements UserService {
        @Override
        public void sayHello() {
            System.out.println("sayHello");
        }
    }
}
