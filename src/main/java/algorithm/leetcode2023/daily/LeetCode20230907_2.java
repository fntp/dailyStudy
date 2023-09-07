package algorithm.leetcode2023.daily;

import javabase.datastructure.binarytree.TreeNode;

/**
 * @author fntp
 * @since 2023/9/7
 */
public class LeetCode20230907_2 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        //求解对称二叉树
        return doSy(root.left,root.right);
    }

    private boolean doSy(TreeNode left, TreeNode right) {
        if (left==null && right==null) {
            return true;
        }
        if (left == null||right == null) {
            return false;
        }
        if (left.val!= right.val) {
            return false;
        }
        return doSy(left.left,right.right) && doSy(left.right,right.left);
    }

}
