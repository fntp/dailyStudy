package algorithm.leetcode2023.daily;
import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-15  14:27
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230815_4 {

    public static void main(String[] args) {
        // int[] a1 = {1, 5, 6, 2, 4, 10, 11};
        // int[] a2 = new int[a1.length];
        // merge2(a1, 0, 2, 3, 6, a2,0);
        // System.out.println("a2："+Arrays.toString(a2));
        // System.arraycopy(a2, 0, a1, 0, a2.length);
        // System.out.println("a1："+Arrays.toString(a1));
        // int[] a1 = {1,2,3,0,0,0};
        int[] a1 = {0};
        // int m = 3;
        int m = 0;
        int[] a2 = {1};
        // int[] a2 = {2,5,6};
        // int n = 3;
        int n = 1;
        new LeetCode20230815_4().merge1(a1,m,a2,n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m==0&&n==0) {
            return;
        }
        if (m==0&&n==1) {
            nums1 = nums2;
        }
        int[] cacheArray = new int[nums1.length];
        // 初始化设置一下参数
        int k = 0, mIndex = 0,nIndex = 0;
        while (mIndex<= m-1&&nIndex<=n-1) {
            if (nums1[mIndex]<nums2[nIndex]) {
                cacheArray[k++] = nums1[mIndex++];
            }else {
                cacheArray[k++] = nums2[nIndex++];
            }
        }
        if (nIndex > n-1) {
            System.arraycopy(nums1,mIndex,cacheArray,k,m-mIndex);
        }
        if (mIndex > m-1 ) {
            System.arraycopy(nums2,nIndex,cacheArray,k,n-nIndex);
        }
        nums1 = cacheArray;
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 归并排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m==0&&n==0) {
            return;
        }
        if (m==0&&n==1) {
            System.arraycopy(nums2,0,nums1,0,n);
        }
        int[] cacheArray = new int[nums1.length];
        // 初始化设置一下参数
        int k = 0, mIndex = 0,nIndex = 0;
        while (mIndex<= m-1&&nIndex<=n-1) {
            if (nums1[mIndex]<nums2[nIndex]) {
                cacheArray[k++] = nums1[mIndex++];
            }else {
                cacheArray[k++] = nums2[nIndex++];
            }
        }
        if (nIndex > n-1) {
            System.arraycopy(nums1,mIndex,cacheArray,k,m-mIndex);
        }
        if (mIndex > m-1 ) {
            System.arraycopy(nums2,nIndex,cacheArray,k,n-nIndex);
        }
        System.arraycopy(cacheArray,0,nums1,0,cacheArray.length);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 非递归版本实现
     * @param a1
     * @param i
     * @param iEnd
     * @param j
     * @param jEnd
     * @param a2
     * @param k
     */
    public static void merge2(int[] a1, int i, int iEnd, int j, int jEnd,
                             int[] a2, int k) {
        // 当指针在数据范围内
        while (i<=iEnd&&j<=jEnd) {
            if (a1[i]<a1[j]) {
                a2[k++] = a1[i++];
            }else {
                a2[k++] = a1[j++];
            }
        }
        if (i>iEnd) {
            System.arraycopy(a1,j,a2,k,jEnd-j+1);
        }
        if (j>jEnd) {
            System.arraycopy(a1,i,a2,k,iEnd-i+1);
        }
    }

    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd,
                             int[] a2, int k) {
        if (i > iEnd) {
            System.arraycopy(a1,j,a2,k,jEnd-j+1);
        }
        if (j > jEnd) {
            System.arraycopy(a1,i,a2,k,iEnd-i+1);
        }
        if (a1[i] < a1[j]){
            a2[k++] = a1[i];
            merge(a1,i+1,iEnd,j,jEnd,a2,k);
        }else {
            a2[k++] = a1[j];
            merge(a1,i,iEnd,j+1,jEnd,a2,k);
        }
    }

}
