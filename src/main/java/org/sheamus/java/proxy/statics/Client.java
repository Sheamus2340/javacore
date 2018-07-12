package org.sheamus.java.proxy.statics;

/**
 * 静态代理：
 *  1. 代理类和被代理类要实现相同的接口；
 *  2. 代理类有一个被代理接口的引用；
 *  3. 代理类有一个被代理参数接口的构造方法；
 *  4. 客户端创建被代理类的实例完成调用；
 *
 * 缺点：
 *  1. 代理类和被代理类要实现相同的接口，这样会有很多的代理类的产生；
 *  2. 一旦被代理类增加一个方法，代理类也要跟着修改；
 * Created by Sheamus on 2018/7/11.
 */
public class Client {
    public static void main(String[] args) {
        IUserDao userDao = new UserDaoImpl();
        UserProxy proxy = new UserProxy(userDao);
        proxy.save();
    }
}
