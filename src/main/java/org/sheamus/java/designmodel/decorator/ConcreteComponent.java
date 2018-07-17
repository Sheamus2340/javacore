package org.sheamus.java.designmodel.decorator;

/**
 * 具体构件角色（Concrete Component）：定义将要接收附加责任的类。
 * Created by Sheamus on 2018/7/17.
 */
public class ConcreteComponent implements Component {
    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
