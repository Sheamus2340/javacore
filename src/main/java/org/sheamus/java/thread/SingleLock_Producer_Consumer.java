package org.sheamus.java.thread;

/**
 * Created by Sheamus on 2018/7/13.
 */
public class SingleLock_Producer_Consumer {
    public static void main(String[] args) {
        KaoyaResourceByLock resourceByLock = new KaoyaResourceByLock();
        Product product = new Product(resourceByLock);
        Consume consume = new Consume(resourceByLock);

        Thread thread1 = new Thread(product,"product");
        Thread thread2 = new Thread(consume,"consume");

        thread1.start();
        thread2.start();
    }
}

class Product implements Runnable {
    private KaoyaResourceByLock resourceByLock;

    public Product(KaoyaResourceByLock resourceByLock) {
        this.resourceByLock = resourceByLock;
    }

    @Override
    public void run() {
        while(true) {
            resourceByLock.product("烤鸭");
        }
    }
}

class Consume implements Runnable {
    private KaoyaResourceByLock resourceByLock;

    public Consume(KaoyaResourceByLock resourceByLock) {
        this.resourceByLock = resourceByLock;
    }

    @Override
    public void run() {
        while(true) {
            resourceByLock.consume();
        }
    }
}