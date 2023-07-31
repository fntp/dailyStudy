package algorithm.leetcode2023.daily;

import algorithm.nowcoder.NowCoder0726.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author fntp
 * @since 2023/7/27
 */
public class LeetCode20230727_3 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(4);
        LeetCode20230727_3 tree = new LeetCode20230727_3();
        List<Integer> integers = tree.inorderTraversal(node);
        integers.forEach(System.out::print);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root==null){
            return result;
        }
        indicator(root,result);
        return result;
    }

    public static void indicator(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }
        indicator(root.left,res);
        res.add(root.val);
        indicator(root.right,res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
