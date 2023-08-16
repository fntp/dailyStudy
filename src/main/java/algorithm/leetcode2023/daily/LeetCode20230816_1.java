package algorithm.leetcode2023.daily;

import javabase.datastructure.binarytree.TreeNode;
import javabase.datastructure.queue.LinkedListQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-16  20:41
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230816_1 {

    // 使用队列实现 二叉树的层次遍历

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> levelList = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node!=null) {
                    levelList.add(node.val);
                    if (node.left!=null) {
                        queue.offer(node.left);
                    }
                    if (node.right!=null) {
                        queue.offer(node.right);
                    }
                }
            }
           result.add(levelList);
        }
        return result;
    }



}
