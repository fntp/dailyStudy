package javabase.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: javabase.juc
 * @Author: fntp
 * @CreateTime: 2023-08-09  13:56
 * @Description: TODO
 * @Version: 1.0
 */
public class TestParkAndUnPark {

    private static Thread a;

    private static Thread b;

    private static Thread c;

    {
        ParkAndUnPark parkAndUnPark = new ParkAndUnPark(5);
        a = new Thread(()-> parkAndUnPark.print("a",b),"a");
        b = new Thread(()-> parkAndUnPark.print("b",c),"c");
        c = new Thread(()-> parkAndUnPark.print("c",a),"b");
    }
    public static void main(String[] args) {
        new TestParkAndUnPark().test();
    }

    public void test() {
         a.start();
         b.start();
         c.start();
         LockSupport.unpark(a);
    }

    class ParkAndUnPark {

        private int loopnumer;

        public ParkAndUnPark (int loopnumer) {
            this.loopnumer = loopnumer;
        }

        public void print(String value, Thread nextThread) {
            for (int i = 0; i < loopnumer; i++) {
                LockSupport.park();
                System.out.print(value);
                LockSupport.unpark(nextThread);
            }
        }

    }

}
