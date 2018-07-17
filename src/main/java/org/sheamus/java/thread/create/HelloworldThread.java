package org.sheamus.java.thread.create;

/**
 * Created by Sheamus on 2018/7/16.
 */
public class HelloworldThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new HelloworldThread(),"t1");
        t1.start();
        t1.interrupt();
        if(t1.isInterrupted()) {
            System.out.println("sssssss");
        }
    }
}
