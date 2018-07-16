package org.sheamus.java.threadpool.fixed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Sheamus on 2018/7/16.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }
}
