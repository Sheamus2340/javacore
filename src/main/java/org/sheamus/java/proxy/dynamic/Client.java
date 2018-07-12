package org.sheamus.java.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Created by Sheamus on 2018/7/11.
 */
public class Client {
    public static void main(String[] args) {
        IHelloWorld helloWorld = (IHelloWorld)Proxy.newProxyInstance(IHelloWorld.class.getClassLoader(),
                /*new Class[]{IHelloWorld.class}*/HelloWorldImpl.class.getInterfaces(),
                new MyInvocationHandler(new HelloWorldImpl()));
        helloWorld.sayHelloWorld();
    }
}
