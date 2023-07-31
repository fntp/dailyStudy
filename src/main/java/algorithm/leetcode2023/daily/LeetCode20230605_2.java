package algorithm.leetcode2023.daily;

/**
 * @author puye(0303)
 * @since 2023/6/5
 */
public class LeetCode20230605_2 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length,n=mat[0].length;
        if (m*n != r*c){
            return mat;
        }
        int[][] newArray = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            setValue(newArray,i,getValue(mat,i));
        }
        return newArray;
    }

    /**
     * 根据一维坐标获取老数组数据
     * @param oldArray
     * @param index
     * @return
     */
    private int getValue(int[][] oldArray, int index){
        int m =  oldArray[0].length;
        int r = index / m;
        int c = index % m;
        return oldArray[r][c];
    }

    public void setValue(int[][] newArray, int index,int target){
        int m =  newArray[0].length;
        int r = index / m;
        int c = index % m;
        newArray[r][c] = target;
    }
}
