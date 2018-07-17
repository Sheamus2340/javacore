package org.sheamus.java.designmodel.decorator.coverrice;

/**
 * 肉盖饭
 * Created by Sheamus on 2018/7/17.
 */
public class MeatCoverRice extends CoverRice {
    public MeatCoverRice(Rice rice) {
        super(rice);
    }

    @Override
    public int cost() {
        System.out.println("肉盖饭加10元");
        return super.cost() + 10;
    }
}
