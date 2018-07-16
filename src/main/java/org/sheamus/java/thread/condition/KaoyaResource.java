package org.sheamus.java.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 分别使用product_condition和consume_condition来进行同步通信
 * 烤鸭的资源
 * Created by Sheamus on 2018/7/13.
 */
public class KaoyaResource {
    private String name; // 烤鸭的名称
    private int num = 0; // 烤鸭的编号
    private int count = 0; // 烤鸭的数量
    private boolean flag = false; // 是否有烤鸭的标识
    // 非公平锁
    private Lock lock = new ReentrantLock();
    // 生产者的条件对象
    private Condition product_condition = lock.newCondition();
    // 消费者的条件对象
    private Condition consume_condition = lock.newCondition();

    public void product() {
        try {
            lock.lock();
            while(flag) {
                // 阻塞生产鸭子的线程,现在是由鸭子的
                product_condition.await();
            }
            // 没有烤鸭了，需要生产
            num++;
            count++;
            flag = true; // 已经有鸭子了就不用生产了
            this.name = "烤鸭" + num;
            System.out.println(Thread.currentThread().getName() + "生产了一个烤鸭，当前烤鸭的编号：" + num + " 数量是:" + count + " 名称: " + name);
            consume_condition.signal();
        } catch(Exception e) {
            Thread.interrupted();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        try {
            lock.lock();
            while(!flag) {
                consume_condition.await();
            }
            count--;
            flag = false; // 没有鸭子了
            System.out.println(Thread.currentThread().getName() + "--------------消费了一个烤鸭，当前烤鸭的编号：" + num + " 数量是:" + count + " 名称: " + name);
            product_condition.signal();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

}
