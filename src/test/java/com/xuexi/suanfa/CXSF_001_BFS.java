package com.xuexi.suanfa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 宝宝和妈妈参加亲子游戏，在一个二维矩阵（N*N）的格子地图上，宝宝和妈妈抽签决定各自的位置，地图上每个格子有不同的糖果数量，部分格子有障碍物。
 * 游戏规则是妈妈必须在最短的时间（每个单位时间只能走一步）到达宝宝的位置，路上的所有糖果都可以拿走，不能走障碍物的格子，只能上下左右走。
 * 请问妈妈在最短到达宝宝位置的时间内最多拿到多少糖果（优先考虑最短时间到达的情况下尽可能多拿糖果）。
 * @author fntp
 * @since 2024/11/21
 */
public class CXSF_001_BFS {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};


        public static int collectCandies(int[][] grid, int[] momPos, int[] babyPos) {
            int N = grid.length;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            int[][] candyCollected = new int[N][N]; // 用于记录到达每个位置时收集的糖果数量
            queue.add(momPos);
            visited[momPos[0]][momPos[1]] = true;
            candyCollected[momPos[0]][momPos[1]] = grid[momPos[0]][momPos[1]]; // 妈妈起始位置的糖果

            int maxCandies = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];

                for (int i = 0; i < 4; i++) {
                        int newX = x + dx[i];
                    int newY = y + dy[i];

                    if (newX >= 0 && newX < N && newY >= 0 && newY < N && !visited[newX][newY] && grid[newX][newY] != -1) {
                        visited[newX][newY] = true;
                        int newCandies = candyCollected[x][y] + grid[newX][newY]; // 收集当前格子的糖果
                        candyCollected[newX][newY] = newCandies;
                        queue.add(new int[]{newX, newY});

                        if (newX == babyPos[0] && newY == babyPos[1]) {
                            maxCandies = Math.max(maxCandies, newCandies); // 更新最大糖果数量
                        }
                    }
                }
            }

            return maxCandies;
        }

        public static void main(String[] args) {
            int N = 5; // 地图大小
            int[][] grid = {
                    {0, 2, 0, 0, 0},
                    {3, 0, 0, 0, 0},
                    {0, 0, -1, 0, 5},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 2, 0}
            };
            int[] momPos = {0, 0}; // 妈妈起始位置
            int[] babyPos = {4, 4}; // 宝宝位置

            int maxCandies = collectCandies(grid, momPos, babyPos);
            System.out.println("Maximum candies collected: " + maxCandies);
        }
    }

