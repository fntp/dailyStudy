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

    /**
     * 当有序数组中出现重复元素的时候，进行二分搜索，
     * 搜索某个元素第一次出现的位置，就用leftMost，
     * 查找最后一次出现的位置，就用rightMost
     * 当查询目标是目标数组中不存在的数据
     * 找不到的时候，i表示的是找到比目标数据大的且最靠左的数据
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 极端情况的时候普通二分复杂度不平均
     * 因此这里就讲一种平均速度的二分
     * @param nums
     * @param target
     * @return
     */
    public int search_average(int[] nums, int target) {
        int i = 0, j = nums.length;
        // j所指向的不在取值范围内，因此当i与j之间相差等于1的时候，这时候代表i与j范围内没有可用于比较的数据
        while (1<j-i) {
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
