package org.sheamus.java.designmodel.decorator.eg;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class Whip implements Beverage {

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        System.out.println("奶泡价格是20元");
        return 20 + beverage.cost();
    }
}
