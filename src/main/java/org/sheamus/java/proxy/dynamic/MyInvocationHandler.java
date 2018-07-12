package org.sheamus.java.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Sheamus on 2018/7/11.
 */
public class MyInvocationHandler implements InvocationHandler {
    // 目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    /**
     * @param proxy 指代我们被代理的那个真实对象
     * @param method 指代的是我们所要调用真实对象的某个方法的Method对象
     * @param args 指代的是调用真实对象某个方法时接受的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*System.out.println(proxy);*/
        System.out.println("-------插入前置通知代码----------");
        // 执行相应的目标代码
        Object invoke = method.invoke(target, args);
        System.out.println("-------插入后置处理代码-----------");
        return invoke;
    }
}
