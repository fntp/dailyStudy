package suanfa.leetcode2023.daily;

/**
 * @author puye(0303)
 * @since 2023/6/5
 */
public class LeetCode20230605_3 {

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
        int startRow = 0,startColumn = n;
        while (startColumn>=0&&startRow<m){
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
