package org.sheamus.java.threadpool.fixed;

/**
 * Created by Sheamus on 2018/7/16.
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int takeCount = 0;
    private final int id = takeCount++;

    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + " ( " + (countDown > 0 ? countDown : "LiftOff!") + ") ";
    }

    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
