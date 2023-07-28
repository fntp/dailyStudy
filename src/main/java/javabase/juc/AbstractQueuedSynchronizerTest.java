package javabase.juc;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author puye(0303)
 * @since 2023/7/27
 */
public class AbstractQueuedSynchronizerTest {

    public static void main(String[] args) {
        // AbstractQueuedSynchronizer
        AbstractQueuedSynchronizerTest test = new AbstractQueuedSynchronizerTest();
         test.getMyName();
    }


    public final String getMyName(){
        return new String("scx");
    }

}
