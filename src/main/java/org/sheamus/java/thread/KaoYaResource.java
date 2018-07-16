package org.sheamus.java.thread;

/**
 * Created by Sheamus on 2018/7/13.
 */
public class KaoYaResource {
    private String name; // 烤鸭的名称
    private int count = 1; // 烤鸭的初始数量
    private boolean flag = false; // 判断是否需要线程需要等待,开始有烤鸭所以不需要等待

    /**
     *  生产烤鸭
     * @param name
     */
    public synchronized void product(String name) {
        while(flag) { // 此时有烤鸭需要等待
            try {
                System.out.println("当前的生产者等待 " + Thread.currentThread().getName());
                this.wait(); // 这里要注意的是，当当前线程被唤醒的时候，要重新判断一下进入的条件，要不然就会出现问题，所以这里要用while
                System.out.println("当前的生产者被唤醒 " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.name = name + count; // 设置烤鸭的名称
        count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..烤鸭的名称是：" + this.name);
        flag = true; // 有烤鸭后改变标识
        notifyAll(); // //通知消费线程可以消费了,唤醒的是阻塞在当前对象上的线程
    }

    public synchronized void consume() {
        while(!flag) { // 如果没有烤鸭就等待
            try {
                System.out.println("当前的消费者等待 " + Thread.currentThread().getName());
                this.wait(); // 这里要注意的是，当当前线程被唤醒的时候，要重新判断一下进入的条件，要不然就会出现问题，所以这里要用while
                System.out.println("当前的消费者被唤醒 " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "...消费者..烤鸭的名称是：" + this.name);//消费烤鸭1
        flag = false;
        notifyAll(); // 通知生产者生产烤鸭,唤醒的是阻塞在当前对象上的线程
    }

}
