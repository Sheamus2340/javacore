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

    /**
     * @param o               Object为由CGLib动态生成的代理类实例
     * @param method          Method为上文中实体类所调用的被代理的方法引用
     * @param objects         Object[]为参数值列表
     * @param methodProxy     MethodProxy为生成的代理类对方法的代理引用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理类的名称" + o.getClass().getName());
        System.out.println("------before------");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("------after-------");
        return o1;
    }
}
