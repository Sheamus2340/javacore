package org.sheamus.java.proxy.statics;

/**
 * 被代理类
 * Created by Sheamus on 2018/7/11.
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public void save() {
        System.out.println("Hello World！！！");
    }
}
