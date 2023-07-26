package suanfa.nowcoder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author puye(0303)
 * @since 2023/7/26
 */
public class NowCoder0726 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> finalRes = new LinkedList<>();
       if (root==null){
           return finalRes;
       }
       Deque<TreeNode> queue = new ArrayDeque<>();
       queue.offer(root);
       boolean flag = true;
       while (!queue.isEmpty()){
           int size = queue.size();
           TreeNode currentNode = queue.poll();
           LinkedList<Integer> levelNode = new LinkedList<>();
           for (int i = 0; i < size; i++) {
               if (flag) {
                   levelNode.addLast(currentNode.val);
               }else {
                   levelNode.addFirst(currentNode.val);
               }
               if (currentNode.left!=null) {
                   queue.offer(currentNode.left);
               }
               if (currentNode.right!=null) {
                   queue.offer(currentNode.right);
               }
           }
            flag = !flag;
            finalRes.add(levelNode);
       }
       return finalRes;
    }
}
