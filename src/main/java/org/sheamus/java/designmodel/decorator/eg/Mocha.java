package org.sheamus.java.designmodel.decorator.eg;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class Mocha implements Beverage {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        System.out.println("摩卡价格是10元");
        return 10 + beverage.cost();
    }
}
