package org.sheamus.java.thread.create;

/**
 * Created by Sheamus on 2018/7/16.
 */
public class HelloworldRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new HelloworldRunnable(),"t1");
        t1.start();
    }
}
