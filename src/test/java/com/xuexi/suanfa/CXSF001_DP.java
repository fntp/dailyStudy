package com.xuexi.suanfa;

/**
 * 重学算法之动态规划
 *
 * @author fntp
 * @since 2024/11/18
 */
public class CXSF001_DP {


    // 简单暴力递归实现斐波那契数列
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 动态规划实现斐波那契数列，并将每一个步骤的注释都补充完整，并且介绍为什么这么做
    public static int fibDP(int n) {
        if (n <= 1) {
            return n;
        }

        // 初始化数组，用于存储斐波那契数列的结果
        int[] fibArray = new int[n + 1];

        // 初始化前两个数，即 fib(0) 和 fib(1)
        fibArray[0] = 0;
        fibArray[1] = 1;

        // 从下标第 2 个数（实际上第三个数）开始计算，使用动态规划的思想
        for (int i = 2; i <= n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            System.out.println("fib(" + i + ") = " + fibArray[i]);
            System.out.println("fib(" + (i - 1) + ") = " + fibArray[i - 1]);
            System.out.println("fib(" + (i - 2) + ") = " + fibArray[i - 2]);
            System.out.println("fib(" + i + ") = fib(" + (i - 1) + ") + fib(" + (i - 2) + ")");
            System.out.println();
        }
        return fibArray[n];
    }

    public int palouti(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

}
