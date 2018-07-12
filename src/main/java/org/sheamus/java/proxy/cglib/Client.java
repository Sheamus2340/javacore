package org.sheamus.java.proxy.cglib;

/**
 * Created by Sheamus on 2018/7/11.
 */
public class Client {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        HelloWorldImpl proxy = cglibProxy.getProxy(HelloWorldImpl.class);
        proxy.say();
    }
}
