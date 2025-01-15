package cn.tulingxueyuan.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author fntp
 * @date 2025/1/15
 * @apiNote
 */
public class TestThread {

    /**
     * test in jdk 17
     *
     * 线程名：main线程id：1
     * 线程名：Reference Handler线程id：2
     * 线程名：Finalizer线程id：3
     * 线程名：Signal Dispatcher线程id：4
     * 线程名：Attach Listener线程id：5
     * 线程名：Common-Cleaner线程id：13
     * 线程名：Monitor Ctrl-Break线程id：14
     * 线程名：Notification Thread线程id：15
     * @param args
     */
    //public static void main(String[] args) {
    //    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    //    ThreadInfo[] allThreads = threadMXBean.dumpAllThreads(false, false);
    //    for (ThreadInfo threadInfo : allThreads) {
    //        System.out.print("线程名：" + threadInfo.getThreadName());
    //        System.out.println("线程id：" + threadInfo.getThreadId());
    //    }
    //}

    /**
     * test ib jdk 8
     *
     * [6] Monitor Ctrl-Break
     * [5] Attach Listener
     * [4] Signal Dispatcher
     * [3] Finalizer
     * [2] Reference Handler
     * [1] main
     * @param args
     */
    public static void main(String[] args) {
        //Java 虚拟机线程系统的管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos =
                threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] "
                    + threadInfo.getThreadName());
        }
    }

}
