package org.sheamus.java.thread;

/**
 * https://blog.csdn.net/javazejian/article/details/50878665
 * 多生产者和消费模式
 * Created by Sheamus on 2018/7/13.
 */
public class Multi_Producer_Consumer {
    public static void main(String[] args) {
        KaoYaResource resource = new KaoYaResource();
        Producter producter = new Producter(resource);
        Consumter consumter = new Consumter(resource);

        Thread t1 = new Thread(producter,"t1");
        Thread t2 = new Thread(producter,"t2");
        Thread t3 = new Thread(consumter,"t3");
        Thread t4 = new Thread(consumter,"t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Producter implements Runnable {
    private KaoYaResource resource;

    public Producter(KaoYaResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true) {
            resource.product("烤鸭");
        }
    }
}

class Consumter implements Runnable {

    private KaoYaResource resource;

    public Consumter(KaoYaResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true) {
            resource.consume();
        }
    }
}
