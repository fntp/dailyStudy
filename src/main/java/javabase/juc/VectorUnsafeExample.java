package javabase.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author puye(0303)
 * @since 2023/7/10
 */
@Slf4j
public class VectorUnsafeExample {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 100; i++) {
                vector.add(i);
            }
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(() -> {
                synchronized (vector){
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                        log.info("Removed " + i);
                    }
                }
            });
            executorService.execute(() -> {
                synchronized (vector){
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                        log.info("added "+i);
                    }
                }
            });
            executorService.shutdown();
        }
    }

}
