package algorithm.leetcode2023.daily;

/**
 * @author puye(0303)
 * @since 2023/6/2
 */
public class LeetCode20230602_4 {

    public static void main(String[] args) {
        LeetCode20230602_4 leetCode202306024 = new LeetCode20230602_4();

    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }
        if (nums.length==1){
            if (nums[0]>=target){
                return 0;
            }
            return nums.length;
        }
        int leftIndex = 0;
        while (leftIndex<=nums.length-1){
            if (nums[leftIndex]<target){
                leftIndex++;
            }else {
                return leftIndex;
            }
        }
        return nums.length;
    }
}
