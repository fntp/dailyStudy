package algorithm.leetcode2023.base;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-02  16:29
 * @Description: TODO
 * @Version: 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[] {0, 1, 2, 3, 4, 5, 6};
        BinarySearch binarySearch = new BinarySearch();
        int searchResult = binarySearch.search(array,5);
        System.out.println(searchResult);
    }


    public int search(int[] nums, int target) {
        if (nums.length == 0||(nums.length==1&&nums[0] ==target)) {
            return 0;
        }
        int i = 0, j = nums.length - 1, middle;
        if (nums[i]==target){
            return i;
        }
        if(nums[j]==target){
            return j;
        }
        while (i < j){
            middle = (i+j) >>> 1;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                j = middle-1;
            }else if (nums[middle] < target){
                i = middle+1;
            }
        }
        if (nums[i] == target){
            return i;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] == target)) {
            return 0;
        }
        int i = 0, j = nums.length - 1, middle;
        if (nums[i] == target) {
            return i;
        }
        if (nums[j] == target) {
            return j;
        }
        while (i<j){
            middle = (i+j) >>> 1;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                j = middle;
            }else {
                i = middle+1;
            }
        }
        return -1;
    }

}
