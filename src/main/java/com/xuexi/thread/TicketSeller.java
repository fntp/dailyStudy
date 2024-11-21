package com.xuexi.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fntp
 * @since 2024/11/20
 */
public class TicketSeller implements Runnable{

    private volatile static int ticket = 100;

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        TicketSeller seller = new TicketSeller();
        Thread seller1 = new Thread(seller);
        Thread seller2 = new Thread(seller);
        Thread seller3 = new Thread(seller);
        seller1.start();
        seller2.start();
        seller3.start();
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true) {
//            synchronized (this) {
            lock.lock();
            try {
                    if (ticket <= 0) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    lock.unlock();
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }
            }
        }
    }
