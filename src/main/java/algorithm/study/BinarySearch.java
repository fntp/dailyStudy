package algorithm.study;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.study
 * @Author: fntp
 * @CreateTime: 2023-08-04  16:48
 * @Description: TODO
 * @Version: 1.0
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i<=j) {
            int m = (i+j) >>> 1;
            if (nums[m] > target) {
                j = m -1;
            } else if (nums[m] < target) {
                i = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public int searchStronger(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i < j) {
            int m = (i+j) >>> 1;
            if (nums[m] > target) {
                j = m ;
            } else if (nums[m] < target) {
                i = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public int searchLeftMost(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i<=j) {
            int m = (i+j) >>> 1;
            if (nums[m] >=target) {
                j = m -1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public int searchRightMost(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i<=j) {
            int m = (i+j) >>> 1;
            if (nums[m] >target) {
                j = m -1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }

    public int search_average(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i<j-1) {
            int m = (i+j) >>> 1;
            if (nums[m] > target) {
                j = m ;
            } else {
                i = m;
            }
        }
        if (nums[i]==target){
            return i;
        }
        return -1;
    }

}
