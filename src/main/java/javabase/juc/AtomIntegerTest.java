package javabase.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: javabase.juc
 * @Author: fntp
 * @CreateTime: 2023-08-16  13:29
 * @Description: TODO
 * @Version: 1.0
 */
public class AtomIntegerTest {
    public static void main(String[] args) {
        AtomicInteger a1 = new AtomicInteger(5);
        a1.updateAndGet(value-> value << 10);
        System.out.println(a1.get());
    }
}
