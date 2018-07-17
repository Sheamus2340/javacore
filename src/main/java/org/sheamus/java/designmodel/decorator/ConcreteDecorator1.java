package org.sheamus.java.designmodel.decorator;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doAnotherthing();
    }

    public void doAnotherthing() {
        System.out.println("功能B");
    }
}
