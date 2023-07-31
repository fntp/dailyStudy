package algorithm.leetcode2023.daily;

import java.util.Arrays;

/**
 * @author puye(0303)
 * @since 2023/6/1
 */
public class LeetCode20230601 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,4};
        int[] ints = searchRange(nums, 4);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 最优解：双指针 找到就立马返回 不作多余统计
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] addressInt = new int[]{-1,-1};
        if (nums.length==0){
            return addressInt;
        }
        if (nums.length==1){
            if (target==nums[0]){
                return new int[]{0,0};
            }else {
                return addressInt;
            }
        }
        // 初始化两个指针
        int leftIndex = 0, rightIndex = nums.length - 1;
        // 然后计算
        while (leftIndex<nums.length - 1 && rightIndex>0){
            if (addressInt[0]==-1 && nums[leftIndex] == target){
                addressInt[0] = leftIndex;
                if (addressInt[1]!=-1){
                    return addressInt;
                }
            }else {
                leftIndex++;
            }
            if (addressInt[1]==-1 && nums[rightIndex]==target){
                addressInt[1] = rightIndex;
                if (addressInt[0]!=-1){
                    return addressInt;
                }
            }else {
                rightIndex--;
            }
        }
        if (addressInt[0]!=-1&&addressInt[1]==-1){
            addressInt[1] = addressInt[0];
        }
        if (addressInt[1]!=-1&&addressInt[0]==-1){
            addressInt[0] = addressInt[1];
        }
        return addressInt;
    }
}
