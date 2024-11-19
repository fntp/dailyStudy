package com.xuexi.suanfa;

import com.jayway.jsonpath.internal.function.numeric.Max;

/**
 * @author fntp
 * @since 2024/11/19
 */
public class CXSF002_DP {

    public static void main(String[] args) {
        int[] array =  new int[]{2,7,9,3,1};
        System.out.println(rob(array));
    }

    // 打家劫舍
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        // 找出dp数组中最大数
        return dp[nums.length-1];
    }

}
