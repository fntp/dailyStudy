package algorithm.leetcode2023.daily;

import javabase.datastructure.binarytree.TreeNode;

/**
 * @author fntp
 * @since 2023/9/7
 */
public class LeetCode20230829_1 {

    public static void main(String[] args) {

    }

    /**
     * 二叉树展开为链表
     * @param root
     */
    public void flatten(TreeNode root) {

        if(root==null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while(p.right!=null) {
            p = p.right;
        }
        p.right = right;
    }
}
