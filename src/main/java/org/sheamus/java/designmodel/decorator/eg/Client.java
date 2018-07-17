package org.sheamus.java.designmodel.decorator.eg;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class Client {
    public static void main(String[] args) {
        // 奶泡 + 摩卡
        Water water = new Water();
        Mocha mocha = new Mocha(water);
        Whip whip = new Whip(mocha);
        int cost = whip.cost();
        System.out.println(cost);
    }
}
