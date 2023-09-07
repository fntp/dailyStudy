package algorithm.leetcode2023.daily;

import javabase.datastructure.binarytree.TreeNode;

/**
 * @author fntp
 * @since 2023/9/7
 */
public class LeetCode20230907_5 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        turnOver(root);
        return root;
    }

    private void turnOver(TreeNode root) {
        if(root==null) {
            return;
        }

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        turnOver(root.left);
        turnOver(root.right);
    }

    private void reverseTreeNode(TreeNode root) {
        // 到了一个叶子节点直接返回
        if (root==null) {
            return;
        }

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        reverseTreeNode(root.left);
        reverseTreeNode(root.right);
    }

}
