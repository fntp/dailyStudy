package suanfa.leetcode2023.daily;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author puye(0303)
 * @since 2023/6/1
 */
public class LeetCode20230601 {

    public static void main(String[] args) {
        int[] nums = {1};
        int[] ints = searchRange(nums, 1);
        System.out.println(Arrays.toString(ints));
    }

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
        while (leftIndex<nums.length - 1&&rightIndex>0){
            if (addressInt[0]==-1 && nums[leftIndex] == target){
                addressInt[0] = leftIndex;
            }else {
                leftIndex++;
            }
            if (addressInt[1]==-1 && nums[rightIndex]==target){
                addressInt[1] = rightIndex;
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
