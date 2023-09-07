package algorithm.leetcode2023.daily;

import javabase.datastructure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author fntp
 * @since 2023/9/7
 */
public class LeetCode20230907_3 {

    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int leftDeep = maxDepth(root.left);
        int rightDeep = maxDepth(root.right);
        return Integer.max(leftDeep,rightDeep)+1;
    }

    /**
     * 后续遍历写法
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        TreeNode currentNode = root;
        TreeNode pop = null;
        Stack<TreeNode> stack = new Stack<>();
        int deep = 0;
        while (currentNode!=null||!stack.isEmpty()) {
            if (currentNode!=null) {
                stack.push(currentNode);
                deep = Integer.max(stack.size(),deep);
                currentNode = currentNode.left;
            }else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right==null||peekNode.right==pop) {
                    pop = stack.pop();
                }else {
                    currentNode = peekNode.right;
                }
            }
        }
        return deep;
    }

    /**
     * 层次遍历写法
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) {
            queue.offer(root);
        }
        int level = 1;
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                if (node!=null){
                    if (node.left!=null) {
                        queue.offer(node.left);
                    }
                    if (node.right!=null) {
                        queue.offer(node.right);
                    }
                }
            }
            level+=1;
        }
        return level;
    }

}
