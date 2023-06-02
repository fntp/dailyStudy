package suanfa.leetcode2023.daily;

/**
 * @author puye(0303)
 * @since 2023/6/2
 */
public class LeetCode20230602 {
    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        // 先去界定边界问题
        if (nums.length ==0){
            return -1;
        }
        if (nums.length==1){
            return nums[0]==target ? 0 : -1;
        }
        // 然后界定循环 因为数组有序且不存在重复数据
        while (leftIndex<=rightIndex){
            if (nums[leftIndex]==target){
                return leftIndex;
            }else {
                leftIndex++;
            }
            if (nums[rightIndex]==target){
                return rightIndex;
            }else {
                rightIndex--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode20230602 leetCode20230602 = new LeetCode20230602();
        System.out.println(leetCode20230602.search1(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    public int search1(int[] nums, int target) {
        // 先去界定边界问题
        if (nums.length ==0){
            return -1;
        }
        if (nums.length==1){
            return nums[0]==target ? 0 : -1;
        }
        if (nums[0]==target){
            return 0;
        }
        if (nums[nums.length-1]==target){
            return nums.length-1;
        }
        // 初始值
        int rightIndex = nums.length-1;
        int leftIndex = 0;
        while (leftIndex<=rightIndex){
            int middleIndex = (leftIndex+rightIndex)/2;
            if(nums[middleIndex]==target){
                return middleIndex;
            }
            if (nums[middleIndex]>target){
                rightIndex = middleIndex-1;
            }else {
                leftIndex = middleIndex+1;
            }
        }
        return -1;
    }

}
