package com.xuexi.suanfa;

/**
 * @author fntp
 * @since 2024/11/21
 */
public class CXSF_003DP {

    public int minPathSum(int[][] grid) {
        int xLength = grid.length;
        int yLength = grid[0].length;
        int[][] dp = new int[xLength][yLength];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < xLength; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < yLength; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < xLength; i++) {
            for (int j = 1; j < yLength; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[xLength - 1][yLength - 1];
    }

}
