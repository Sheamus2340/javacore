package org.sheamus.java.designmodel.decorator;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doAntherthing();
    }

    private void doAntherthing() {
        System.out.println("功能C");
    }
}
