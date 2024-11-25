package com.xuexi.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fntp
 * @since 2024/11/25
 */
@Slf4j
public class TimedJoinExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            try {
                Thread.sleep(2000); // 模拟耗时操作
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread 1 finished");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            try {
                Thread.sleep(1000); // 模拟耗时操作
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread 2 finished");
        });

        thread1.start();
        thread2.start();

        try {
            System.out.println("Main thread waiting for Thread 1 to finish");
            thread1.join(); // 主线程等待 thread1 完成
            System.out.println("Thread 1 has finished");

            System.out.println("Main thread waiting for Thread 2 to finish");
            thread2.join(); // 主线程等待 thread2 完成
            System.out.println("Thread 2 has finished");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread finished");
    }
}
