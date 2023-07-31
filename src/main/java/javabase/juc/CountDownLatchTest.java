package javabase.juc;

/**
 * @author fntp
 * @since 2023/7/28
 */
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static volatile CountDownLatch latch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {

        // 创建一个计数为5的 CountDownLatch 对象

        // 创建5个线程,每个线程执行task()方法
        for(int i=0; i<5; i++) {
            new Thread(new Worker(latch)).start();
        }

        // 主线程等待latch的计数减为0
        latch.await();

        // 当计数为0时,主线程继续执行
        System.out.println("All tasks completed.");
    }
}

class Worker implements Runnable {

    private CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
       synchronized (latch) {
           // ... 执行任务
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {}

           // 每完成一个任务,减少计数
           latch.countDown();
           System.out.println("执行了一次任务，剩余latch数值是："+latch.getCount());
       }
    }
}
