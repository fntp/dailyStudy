package leetcode2023.search;

/**
 * 搜索插入位置
 * @author fntp
 * 搜索插入位置
 */
public class SearchInsertIndex {
	
	public static void main(String[] args) {
		SearchInsertIndex searchInsertIndex = new SearchInsertIndex();
		int[] array = new int[] {1,2,3,4,5};
		int searchInsertResult = searchInsertIndex.searchInsert(array, 6);
		System.out.println(searchInsertResult);
	}
	
	/**
	 * 搜索插入位置
	 * @param nums 排好序的数组
	 * @param target 目标元素
	 * @return 返回这个目标元素在数组中的下标，如果不存在数组中，那么返回这个元素在原数组中插入的位置
	 */
    public int searchInsert(int[] nums, int target) {
    	// 首先排除特殊情况
    	if(nums[nums.length-1]<target) {
    		return nums.length;
    	}
    	if(nums[0]>target) {
    		return 0;
    	} 
    	int leftIndex = 0;
    	int rightIndex = nums.length-1;
    	while(leftIndex<rightIndex) {
    		int midIndex = leftIndex + (rightIndex-leftIndex)/2;
    		if(nums[midIndex] < target) {
    			leftIndex = midIndex + 1;
    		}else {
    			rightIndex = midIndex;
    		}
    	}
    	return leftIndex;
    }
}
