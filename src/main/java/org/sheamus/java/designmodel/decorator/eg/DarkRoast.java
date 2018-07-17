package org.sheamus.java.designmodel.decorator.eg;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class DarkRoast implements Beverage {

    private Beverage beverage;

    public DarkRoast(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        System.out.println("深焙咖啡价格是15元");
        return 15 + beverage.cost();
    }
}
