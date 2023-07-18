package javabase.juc;

/**
 * @author puye(0303)
 * @since 2023/7/13
 */
public class VolatileTest {

    private static volatile VolatileTest instance;

    /**
     * Create a new instance
     */
    private VolatileTest () {}

    public static VolatileTest getInstance() {
        if (instance == null) {
            synchronized (VolatileTest.class){
                if (instance == null){
                    instance = new VolatileTest();
                }
                return instance;
            }
        }
        return instance;
    }

    public final void test() {
    }

    public final void test(String str) {
    }

}
