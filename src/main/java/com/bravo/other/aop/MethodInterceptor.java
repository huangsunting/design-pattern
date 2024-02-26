package com.bravo.other.aop;



public interface MethodInterceptor {

    Object invoke(MethodInvocation invocation) throws Throwable;

}
