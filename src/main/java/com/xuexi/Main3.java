package com.xuexi;

/**
 * @author fntp
 * @date 2025/1/19
 * @apiNote
 */
public class Main3 {

    public static void main(String[] args) {
        System.out.println(f1(3));
    }

    public static int f1(int n) {
        if (n <= 2) {
            return 1;
        }
        return f1(n-1) + f1(n - 2);
    }

    public static int f2(int n) {
        if (n <= 2) {
            return 1;
        }
        int pre = 1;
        int prepre = 1;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = pre + prepre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}
