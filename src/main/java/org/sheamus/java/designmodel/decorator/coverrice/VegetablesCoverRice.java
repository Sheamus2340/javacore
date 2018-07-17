package org.sheamus.java.designmodel.decorator.coverrice;

/**
 * 素盖饭
 * Created by Sheamus on 2018/7/17.
 */
public class VegetablesCoverRice extends CoverRice {
    public VegetablesCoverRice(Rice rice) {
        super(rice);
    }

    @Override
    public int cost() {
        System.out.println("素盖饭加5元");
        return super.cost() + 5;
    }
}
