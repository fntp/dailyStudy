package cn.tulingxueyuan.sync;

import java.util.concurrent.CompletableFuture;

/**
 * @author fntp
 * @date 2025/2/11
 * @apiNote
 */
public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(()->{return "task1 is ok";});
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
                return "task2 is ok";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2);
        allTasks.thenRun(()->{
            System.out.println("task1:"+task1.getNow(null));
            System.out.println("task2:"+task2.getNow(null));
            System.out.println("allTasks done!");
        }).join();
    }
}
