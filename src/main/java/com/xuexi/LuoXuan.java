package com.xuexi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋数组
 * @author fntp
 * @date 2025/1/18
 * @apiNote
 */
public class LuoXuan {

    public static List<Integer> spiralOrder(int[][] matrix) {
        // 明确输出
        List<Integer> resultList = new ArrayList<>();
        // 获取行数，如果行数为0 直接返回结果
        int row = matrix.length;
        if (row == 0) {
            return resultList;
        }
        // 开始遍历二位数组所有数据,这是一个mxn的矩阵，从第一个元素螺旋到最后一个元素不重复，一共需要走mxn步
        int m = matrix[0].length;
        // 确定在什么时候需要调转方向 一共四个方向，首先向右，其次向下，然后向左，最后向上
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};
        // 标记走过的位置
        boolean[][] visited = new boolean[row][m];
        // 开始一步一步走，走i步
        for (int i = 0, x =0, y = 0, direction = 0; i <row * m; i++) {
            // 每走一步 记录走过的路
            visited[x][y] = true;
            resultList.add(matrix[x][y]);
            // 所以每走一步，都需要获取下一步的方向，看看下一步是否需要掉转方向
            // 所以先看看如果按照当前方向继续走，下一步会走到哪里
            int newX = x + directionX[direction];
            int newY = y + directionY[direction];
            // 现在新的未来坐标已经获取到了就看看下一步是否需要掉头
            if (newX < 0 || newX >= row || newY < 0 || newY >= m || visited[newX][newY]) {
                // 如果需要掉头，就改变方向
                direction = (direction + 1) % 4;
                newX = x + directionX[direction];
                newY = y + directionY[direction];
            }

            x = newX;
            y = newY;
        }

        return resultList;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
    }

}
