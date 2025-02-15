package com.xuexi.sf.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fntp
 * @date 2025/2/15
 * @apiNote
 */
public class LCP52 {

    private List<Integer> sortedValues = new ArrayList<>();
    private int[] parent; // 并查集父节点数组
    private int colorRed = 1;

    public int getNumber(TreeNode root, int[][] ops) {
        inOrder(root); // 中序得到有序数组
        int n = sortedValues.size();
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        int res = 0;
        boolean[] isRed = new boolean[n];

        // 逆序处理操作
        for (int i = ops.length  - 1; i >= 0; i--) {
            int type = ops[i][0], x = ops[i][1], y = ops[i][2];
            int l = lowerBound(x), r = upperBound(y) - 1;
            if (l > r) continue;

            for (int j = find(l); j <= r; j = find(j + 1)) {
                if (type == colorRed && !isRed[j]) {
                    isRed[j] = true;
                    res++;
                } else if (type != colorRed && isRed[j]) {
                    isRed[j] = false;
                    res--;
                }
                union(j, j + 1); // 合并已处理区间
            }
        }
        return res;
    }

    // 中序遍历生成有序数组
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        sortedValues.add(root.val);
        inOrder(root.right);
    }

    // 二分查找左边界
    private int lowerBound(int x) {
        int l = 0, r = sortedValues.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (sortedValues.get(mid)  >= x) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // 二分查找右边界
    private int upperBound(int y) {
        int l = 0, r = sortedValues.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (sortedValues.get(mid)  > y) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // 并查集路径压缩
    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        parent[x] = y;
    }
}
