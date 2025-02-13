package com.xuexi.sf.day01;

/**
 * @author fntp
 * @date 2025/2/13
 * @apiNote
 */
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;


    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void traverseLeft(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.print(rootNode.val + " ");
        traverseLeft(rootNode.left);
        traverseLeft(rootNode.right);
    }

    public void traverseRight(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        traverseRight(rootNode.left);
        traverseRight(rootNode.right);
        System.out.print(rootNode.val + " ");
    }

    public void traverse(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        traverse(rootNode.left);
        System.out.print(rootNode.val + " ");
        traverse(rootNode.right);
    }

    public static void main(String[] args) {
        // 创建一个value从1到8的完全平衡二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        // 前序遍历
        System.out.println("前序遍历：");
        root.traverseLeft(root);
        System.out.println();

        // 中序遍历
        System.out.println("中序遍历：");
        root.traverse(root);
        System.out.println();

        // 后序遍历
        System.out.println("后序遍历：");
        root.traverseRight(root);
        System.out.println();
    }

}
