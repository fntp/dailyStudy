package algorithm.leetcode2023.daily;

import javabase.datastructure.binarytree.TreeNode;

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
public class LeetCode20230816_2 {

    // 使用队列实现 二叉树的层次遍历

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> finalResult = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> currentLevelList = new LinkedList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode!=null) {
                    // 先加入
                    currentLevelList.add(currentNode.val);
                    if (currentNode.left!=null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right!=null) {
                        queue.offer(currentNode.right);
                    }
                }
            }
            finalResult.add(currentLevelList);
        }
        return finalResult;
    }



}
