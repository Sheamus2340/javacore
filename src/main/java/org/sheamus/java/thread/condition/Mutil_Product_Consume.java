package org.sheamus.java.thread.condition;

/**
 * Created by Sheamus on 2018/7/13.
 */
public class Mutil_Product_Consume {

    public static void main(String[] args) {
        KaoyaResource resource = new KaoyaResource();
        Product product = new Product(resource);
        Consume consume = new Consume(resource);

        Thread t1 = new Thread(product,"t1");
        Thread t2 = new Thread(product,"t2");
        Thread t3 = new Thread(consume,"t3");
        Thread t4 = new Thread(consume,"t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class Product implements Runnable {

    private KaoyaResource resource;

    public Product(KaoyaResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true) {
            resource.product();
        }
    }
}

class Consume implements Runnable {

    private KaoyaResource resource;

    public Consume(KaoyaResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true) {
            resource.consume();
        }
    }
}
