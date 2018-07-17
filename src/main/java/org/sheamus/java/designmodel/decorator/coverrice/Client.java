package org.sheamus.java.designmodel.decorator.coverrice;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class Client {
    public static void main(String[] args) {
        Rice rice = new CookieRice();
        // 肉盖饭
        MeatCoverRice meatCoverRice = new MeatCoverRice(rice);
        int cost = meatCoverRice.cost();
        System.out.println(cost);
    }
}
