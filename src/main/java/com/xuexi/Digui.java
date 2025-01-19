package com.xuexi;

/**
 * @author fntp
 * @date 2025/1/19
 * @apiNote
 */
public class Digui {

    public static void main(String[] args) {
        System.out.println(sum1To100(100));
    }

    public static int sum1To100(int n){
        if (n==1 || n==0) {
            return n;
        }
        return n+sum1To100(n-1);
    }



}
