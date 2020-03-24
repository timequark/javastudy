package com.timequark.sample.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}
