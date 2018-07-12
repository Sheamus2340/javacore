package org.sheamus.java.proxy.statics;

/**
 * Created by Sheamus on 2018/7/11.
 */
public class UserProxy implements IUserDao {
    private IUserDao target;

    public UserProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("----before-----");
        target.save();
        System.out.println("----after-----");
    }
}
