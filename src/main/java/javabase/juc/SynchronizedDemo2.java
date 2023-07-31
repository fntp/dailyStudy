package javabase.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fntp
 * @since 2023/7/31
 */
public class SynchronizedDemo2 {

    Object object = new Object();
    public void method1() {
        synchronized (object) {

        }
        method2();
    }

    private static void method2() {

    }

    public void testAtomic(){
        AtomicInteger integer = new AtomicInteger();
        integer.getAndAdd(1);
    }
}
