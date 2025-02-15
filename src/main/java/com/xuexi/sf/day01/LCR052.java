package com.xuexi.sf.day01;

/**
 * @author fntp
 * @date 2025/2/15
 * @apiNote
 */
public class LCR052 {
    private TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        // 创建一个辅助头节点，cur 指向辅助头节点 保留记忆
        TreeNode head = new TreeNode(0,null, null);
        cur = head;
        // 进行中序遍历 DFS
        dfs(root);
        // 返回树的第一个节点。
        return head.right;
    }
    private void dfs(TreeNode node) {
        // 递归终止条件：node 为空
        if(node == null)
            return;
        // 中序遍历：左->中->右
        dfs(node.left);
        // 将当前节点插入重排的树的右子树中，同时更新重排树的最后一个节点。
        cur.right = node;
        cur = cur.right;
        // 将节点的左边节点设置为 null。
        cur.left = null;
        dfs(node.right);
    }

    public static void main(String[] args) {
        // 测试用例： [5,3,6,2,4,null,8,1,null,null,null,7,9]
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(6,
                        null,
                        new TreeNode(8,
                                new TreeNode(7),
                                new TreeNode(9))));
        LCR052 lcr052 = new LCR052();
        TreeNode treeNode = lcr052.increasingBST(root);
        System.out.println(treeNode);
    }

}

 class TreeNode {
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
      public String toString() {
          return "TreeNode{" +
                  "val=" + val +
                  ", left=" + left +
                  ", right=" + right +
                  '}';
      }
  }
