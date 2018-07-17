package org.sheamus.java.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Sheamus on 2018/7/16.
 */
public class HelloworldCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello world";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask 实现了Runnable接口
        FutureTask<String> futureTask = new FutureTask<String>(new HelloworldCallable());
        Thread t1 = new Thread(futureTask,"t1");
        t1.start();
        String s = futureTask.get();
        System.out.println(s);
    }
}
