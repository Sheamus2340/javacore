package org.sheamus.java.designmodel.decorator.coverrice;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class CookieRice implements Rice {
    @Override
    public int cost() {
        System.out.println("白饭的价格是5元");
        return 5;
    }
}
