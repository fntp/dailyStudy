package javabase.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: javabase.juc
 * @Author: fntp
 * @CreateTime: 2023-08-09  13:32
 * @Description: TODO
 * @Version: 1.0
 */
public class TestReentrantlock {

    public static void main(String[] args) throws InterruptedException {
        new TestReentrantlock().test();
    }

    public void test() throws InterruptedException {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        new Thread(()-> awaitSignal.print("a",a,b),"t-a").start();
        new Thread(()->awaitSignal.print("b",b,c),"t-b").start();
        new Thread(()->awaitSignal.print("c",c,a),"t-c").start();
        Thread.sleep(1000);
        awaitSignal.lock();
        try {
            a.signal();
            System.out.println("boot已开始唤醒a");
        } finally {
            awaitSignal.unlock();
        }

    }

    class AwaitSignal extends ReentrantLock {
        private int loopnumber;

        public AwaitSignal(int loopnumber) {
            this.loopnumber = loopnumber;
        }

        public void print(String value, Condition current, Condition next) {
            for (int i = 0; i < loopnumber; i++) {
                lock();
                try {
                    current.await();
                    System.out.print(value);
                    next.signal();
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    unlock();
                }
            }
        }
    }

}
