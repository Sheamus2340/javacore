package org.sheamus.java.designmodel.decorator.coverrice;

/**
 * 盖浇饭
 * Created by Sheamus on 2018/7/17.
 */
public class CoverRice implements Rice {

    private Rice rice;

    public CoverRice(Rice rice) {
        this.rice = rice;
    }

    @Override
    public int cost() {
        return rice.cost();
    }
}
