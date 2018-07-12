package org.sheamus.java.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Sheamus on 2018/7/11.
 */
public class CglibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("------before------");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("------after-------");
        return o1;
    }
}
