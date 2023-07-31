package algorithm.leetcode2023.daily;

import algorithm.nowcoder.NowCoder0726.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fntp
 * @since 2023/7/27
 */
public class LeetCode20230727 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size  = queue.size();
            LinkedList<Integer> levelData = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                levelData.addLast(currentNode.val);
                if (currentNode.left!=null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right!=null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(levelData);
        }
        return result;
    }

}
