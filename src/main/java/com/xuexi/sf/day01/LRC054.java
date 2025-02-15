package com.xuexi.sf.day01;

/**
 * @author fntp
 * @date 2025/2/15
 * @apiNote
 */
public class LRC054 {
    int maxValue = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        // 递归终止条件：node 为空
        if(root == null)
            return ;
        // 倒中序遍历：右->中->左
        dfs(root.right);
        maxValue += root.val;
        root.val = maxValue;
        dfs(root.left);
    }


    public static void main(String[] args) {
        /**
         * 输入：root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8] 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
         */
        // 构建树  [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        TreeNode root = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2,
                                new TreeNode(3),
                                null)),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7,
                                null,
                                new TreeNode(8))));
        LRC054 lrc054 = new LRC054();
        TreeNode treeNode = lrc054.convertBST(root);
        System.out.println(treeNode);
    }
}
