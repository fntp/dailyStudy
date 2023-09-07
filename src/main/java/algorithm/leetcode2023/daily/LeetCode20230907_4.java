package algorithm.leetcode2023.daily;

import javabase.datastructure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fntp
 * @since 2023/9/7
 */
public class LeetCode20230907_4 {
    /**
     * 二叉树的最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDeep = minDepth(root.left);
        int rightDeep = minDepth(root.right);
        if (leftDeep==0){
            return rightDeep+1;
        }
        if (rightDeep==0){
            return leftDeep+1;
        }
        return Integer.min(leftDeep,rightDeep) + 1;
    }

    public int minDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) {
            queue.offer(root);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level+=1;
                if (node!=null){
                    if (node.left==null&&node.right==null) {
                        return level;
                    }
                    if (node.left!=null) {
                        queue.offer(node.left);
                    }
                    if (node.right!=null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return level;
    }


}
