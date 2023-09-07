package algorithm.leetcode2023.daily;

import javabase.datastructure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author fntp
 * @since 2023/9/7
 */
public class LeetCode20230907_1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(5)),
                1,
                new TreeNode(new TreeNode(6), 3, new TreeNode(7))
        );

        System.out.println(backOrderTraversal(root));

    }

    /**
     * 二叉树的前序遍历
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> treeValueList = new LinkedList<>();
        Stack<TreeNode> memory = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode!=null|| !memory.isEmpty()) {
            if (currentNode!=null) {
                memory.push(currentNode);
                treeValueList.add(currentNode.val);
                currentNode = currentNode.left;
            }else {
                TreeNode backNode = memory.pop();
                currentNode = backNode.right;
            }
        }
        return treeValueList;
    }

    /**
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public static List<Integer> middleOrderTraversal(TreeNode root) {
        List<Integer> treeValueList = new LinkedList<>();
        Stack<TreeNode> memory = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode!=null|| !memory.isEmpty()) {
            if (currentNode!=null) {
                memory.push(currentNode);
                currentNode = currentNode.left;
            }else {
                TreeNode backNode = memory.pop();
                treeValueList.add(backNode.val);
                currentNode = backNode.right;
            }
        }
        return treeValueList;
    }

    /**
     * 二叉树的后序遍历
     * @param root
     * @return
     */
    public static List<Integer> backOrderTraversal(TreeNode root) {
        List<Integer> treeValueList = new LinkedList<>();
        Stack<TreeNode> memory = new Stack<>();
        TreeNode currentNode = root;
        TreeNode popNode = null;
            while (currentNode!=null|| !memory.isEmpty()) {
            if (currentNode!=null) {
                memory.push(currentNode);
                currentNode = currentNode.left;
            }else {
                TreeNode peekNode = memory.peek();
                if (peekNode.right==null||peekNode.right==popNode) {
                    popNode = memory.pop();
                    treeValueList.add(popNode.val);
                }else {
                    currentNode = peekNode.right;
                }
            }
        }
        return treeValueList;
    }

}
