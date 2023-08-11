package algorithm.study;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.study
 * @Author: fntp
 * @CreateTime: 2023-08-10  16:41
 * @Description: TODO
 * @Version: 1.0
 */
public class BinarySearchOfRecursion {

    // 递归实现二分查找

    public static int binarySearchOfRecursion(int[] array, int target, int leftRange, int rightRange) {
        if (leftRange>rightRange) {
            return -1;
        }
        int m = (leftRange+rightRange)>>>1;
        if (target < array[m]) {
            return binarySearchOfRecursion(array,target,leftRange,m-1);
        }else if (target > array[m]) {
            return binarySearchOfRecursion(array, target, m+1, rightRange);
        }else {
            return m;
        }
    }

}
