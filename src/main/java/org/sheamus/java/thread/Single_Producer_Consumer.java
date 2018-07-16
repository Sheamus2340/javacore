package org.sheamus.java.thread;

/**
 * 单生产者和消费者模式
 * Created by Sheamus on 2018/7/13.
 */
public class Single_Producer_Consumer {

    public static void main(String[] args) throws InterruptedException {
        KaoYaResource resource = new KaoYaResource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        Thread thread1 = new Thread(producer,"producer");
        Thread thread2 = new Thread(consumer,"consumer");
        thread2.start();
        Thread.sleep(100);
        thread1.start();
    }

}

class Producer implements Runnable {

    private KaoYaResource resource;

    public Producer(KaoYaResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
//        while(true) {
            resource.product("烤鸭");
//        }
    }
}

class Consumer implements Runnable {
    private KaoYaResource resource;

    public Consumer(KaoYaResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
//        while(true) {
            resource.consume();
//        }
    }
}
