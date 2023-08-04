package algorithm.leetcode2023.daily;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-04  18:38
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * @Version: 1.0
 */
public class LeetCode20230804 {

    public int[] searchRange(int[] nums, int target) {
        return new int[] {searchLeft(nums, target), searchRight(nums, target)};
    }

    public int searchLeft(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        int index = -1;
        while (i<=j){
            int m = (i+j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            }else if (target > nums[m]) {
                i = m + 1 ;
            }else {
                index = m;
                j = m - 1;
            }
        }
        return index;
    }

    public int searchLeftMost(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i<=j){
            int m = (i+j) >>> 1;
            if (target <= nums[m]) {
                j = m - 1;
            }else {
                i = m + 1 ;
            }
        }
        return i;
    }

    public int searchRight(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        int index = -1;
        while (i<=j){
            int m = (i+j) >>> 1;
            if (target < nums[m]) {
                j = m - 1 ;
            } else if (target > nums[m]){
                i = m + 1 ;
            }else {
                index = m;
                i = m + 1 ;
            }
        }
        return index;
    }

    public int searchRightMost(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i<=j){
            int m = (i+j) >>> 1;
            if (target < nums[m]) {
                j = m - 1 ;
            } else {
                i = m + 1 ;
            }
        }
        return i-1;
    }
}
