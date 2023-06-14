package suanfa.leetcode2023.daily;

/**
 * @author puye(0303)
 * @since 2023/6/2
 */
public class LeetCode20230602_5 {

    public static void main(String[] args) {
        LeetCode20230602_5 leetCode202306025 = new LeetCode20230602_5();
        boolean result = leetCode202306025.searchMatrix(new int[][]{new int[]{1, 1}}, 0);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0) {
            return false;
        }
        if (matrix.length==1){
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i]==target){
                    return true;
                }
            }
        }
        // 按列来计算，反正按行看每一行的开头都是最小的
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

}
