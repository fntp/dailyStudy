package javabase.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: javabase.juc
 * @Author: fntp
 * @CreateTime: 2023-08-09  13:18
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
public class TestNotifyAndWait {

    public static void main(String[] args) {
        new TestNotifyAndWait().test();
    }
    public  void test() {
        WaitAndNotify wd = new WaitAndNotify(1,5);
        new Thread(()->{
            wd.print("a",1,2);
        }).start();
        new Thread(()->{
            wd.print("b",2,3);
        }).start();
        new Thread(()->{
            wd.print("c",3,1);
        }).start();
    }

    class WaitAndNotify {
        private int flag;

        private int loopnumber;

        public WaitAndNotify(int flag, int loopnumber) {
            this.flag = flag;
            this.loopnumber = loopnumber;
        }

        public void print(String str,int waitFlag,int nextFlag) {
            for (int i = 0; i < loopnumber; i++) {
                synchronized (this) {
                    while (flag != waitFlag) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(str);
                    flag = nextFlag;
                    this.notifyAll();
                }
            }
        }
    }

}
