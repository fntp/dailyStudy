package algorithm.leetcode2023.daily;

/**
 * @author puye(0303)
 * @since 2023/6/5
 */
public class LeetCode20230605_3 {

    public static void main(String[] args) {
        int[][] source = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        LeetCode20230605_3 leetCode202306053 = new LeetCode20230605_3();
        leetCode202306053.searchMatrix(source,3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n = matrix[0].length;
        if (m==0||n==0||matrix==null){
            return false;
        }
        if (m==1&&n==1){
            return matrix[0][0] == target;
        }
        if (m==1){
            for (int i = 0; i < n; i++) {
                if (matrix[0][i]==target){
                    return true;
                }
            }
        }
        int startRow = 0,startColumn = n-1;
        while (startRow<m&&startColumn>=0){
            if (matrix[startRow][startColumn]==target){
                return true;
            }else if (matrix[startRow][startColumn]>target){
                startColumn--;
            }else {
                startRow++;
            }
        }
        return false;
    }
}
