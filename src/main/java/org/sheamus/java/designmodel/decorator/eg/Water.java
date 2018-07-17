package org.sheamus.java.designmodel.decorator.eg;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class Water implements Beverage {
    @Override
    public int cost() {
        System.out.println("水的价格0元");
        return 0;
    }
}
