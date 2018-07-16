package org.sheamus.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sheamus on 2018/7/13.
 */
public class KaoyaResourceByLock {
    private String name; // 烤鸭的名称
    private int count = 1; // 烤鸭的数量
    private boolean flag = false; // 是否可以消费的标识
    // 新增一个锁对象
    private ReentrantLock lock = new ReentrantLock();
    // 新增一个条件对象
    private Condition condition = lock.newCondition();

    public void product(String name) {
        try {
            lock.lock();
            while(flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.name = name + count;
            count++;
            flag = true;
            System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name + "数量" + count);
            condition.signalAll();
        } catch (Exception e) {
            Thread.interrupted(); //
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        try {
            lock.lock();
            while(!flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.name = name + "---" +count;
            count--;
            flag = false;
            System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name + "数量" + count);
            condition.signalAll();
        } catch (Exception e) {
            Thread.interrupted(); //
        } finally {
            lock.unlock();
        }
    }

}
