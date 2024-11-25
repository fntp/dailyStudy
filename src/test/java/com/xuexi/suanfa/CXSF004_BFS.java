package com.xuexi.suanfa;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fntp
 * @since 2024/11/24
 */
public class CXSF004_BFS {

    @Data
    @NoArgsConstructor
    static class GraphBase {
        /**
         * 节点信息
         */

        private List<Integer> metaList;
        /**
         * 索引-边关系
         */
        private List<List<Integer>> indexRelationList;

        public GraphBase(int[] metaList, int[][] indexRelationList) {
            this.metaList = new ArrayList<>();
            this.indexRelationList = new ArrayList<>();

            for (Integer integer : metaList) {
                this.metaList.add(integer);
            }

            for (int[] r : indexRelationList) {
                List<Integer> list = new ArrayList<>();
                for (int c : r) {
                    list.add(c);
                }
                this.indexRelationList.add(list);
            }
        }
    }

    /**
     * 二叉树翻转
     * @param root 根节点
     * @return 翻转后的根节点
     */
    public TreeNode flipTree(TreeNode root) {
        if (root==null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        flipTree(root.left);
        flipTree(root.right);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
