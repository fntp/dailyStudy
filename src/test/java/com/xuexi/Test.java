package com.xuexi;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fntp
 * @since 2024/11/13
 */
public class Test {

    public static void main(String[] args) {
     ReentrantLock lock = new ReentrantLock();

//        byte a = 100;
//        byte b = 100;
//
//        b += a;
//
//        System.out.println(b);
        Test test = new Test();

        Thread consumerThread = new Thread(() -> test.consumer(lock));

        Thread producerThread = new Thread(() -> test.producer(lock));

        producerThread.start();

        consumerThread.start();

        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        DoubleAdder doubleAdder = new DoubleAdder();

    }

    public void producer(Object lock) {
        synchronized (lock) {
            System.out.println("生产者开始生产");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("好了等待消费------------XXXX");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void consumer(Object lock) {
        synchronized (lock) {
            System.out.println("消费者开始消费");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("好了等待生产--------------SSSS");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
