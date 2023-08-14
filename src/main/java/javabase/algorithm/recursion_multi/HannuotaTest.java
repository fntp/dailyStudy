package javabase.algorithm.recursion_multi;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: javabase.algorithm.recursion_single
 * @Author: fntp
 * @CreateTime: 2023-08-12  14:24
 * @Description: TODO
 * @Version: 1.0
 */
public class HannuotaTest {

    static LinkedList<Integer> a = new LinkedList<Integer>();
    static LinkedList<Integer> b = new LinkedList<Integer>();
    static LinkedList<Integer> c = new LinkedList<Integer>();

    public static void main(String[] args) {
        for (int i = 3; i >0; i--) {
            a.addLast(i);
        }
        print();
        move(a.size(),a,b,c);
    }

    /**
     *
     * @param n
     * @param a
     * @param b
     * @param c
     */
    private static void move(int n, LinkedList<Integer> a,LinkedList<Integer> b,LinkedList<Integer> c) {
        if (n==0){
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        print();
        move(n-1,b,a,c);
    }

    private static void print() {
        System.out.println("----------------------------------");
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));
        System.out.println(Arrays.toString(c.toArray()));
    }
}
