package com.xuexi.suanfa;

/**
 * @author fntp
 * @since 2024/12/3
 */
public class CXSF006_DP {

    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return n;
        }

        int[] leftMaxValue = new int[n];
        int[] rightMaxValue = new int[n];

        leftMaxValue[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMaxValue[i] = Math.max(leftMaxValue[i - 1], height[i]);
        }

        rightMaxValue[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxValue[i] = Math.max(rightMaxValue[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMaxValue[i], rightMaxValue[i]) - height[i];
        }
        return ans;

    }

}
