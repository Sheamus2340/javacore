package org.sheamus.java.proxy.dynamic;

/**
 * Created by Sheamus on 2018/7/11.
 */
public class HelloWorldImpl implements IHelloWorld {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello world");
    }
}
