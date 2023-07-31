package algorithm.leetcode2023.daily;

/**
 * @author puye(0303)
 * @since 2023/6/2
 */
public class LeetCode20230602_2 {
    public static void main(String[] args) {
    //    剑指offer53
        LeetCode20230602_2 leetCode202306022 = new LeetCode20230602_2();
        System.out.println(leetCode202306022.search(new int[]{1, 2, 3}, 2));
    }

    public int search(int[] nums, int target) {
        if (nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            if (nums[0]==target){
                return nums.length;
            }
            return 0;
        }
        int leftIndex = 0,rightIndex = nums.length-1,count = 0;
        while (leftIndex<=rightIndex){
            if (nums[leftIndex]==target) {
                count+=1;
            }
            if (nums[rightIndex]==target) {
                count+=1;
            }
            if (leftIndex==rightIndex){
                count-=1;
            }
            rightIndex--;
            leftIndex++;
        }
        return count;
    }
}
