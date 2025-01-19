package com.xuexi;

/**
 * @author fntp
 * @date 2025/1/19
 * @apiNote
 */
public class Main2 {

    public static void main(String[] args) {
        System.out.println(f1(1));
    }

    public static int f1(int n) {
        if (n < 100) return n + f1(n+1);
        else return n;
    }

    public static int f2(int n) {
        if (n > 1) return n + f2(n-1);
        else return n;
    }
}
