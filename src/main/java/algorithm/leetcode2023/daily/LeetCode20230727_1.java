package algorithm.leetcode2023.daily;

import java.util.HashMap;

/**
 * @author fntp
 * @since 2023/7/27
 */
public class LeetCode20230727_1 {

    public static void main(String[] args) {
        String a = "hello";
        System.out.println(new LeetCode20230727_1().lengthOfLongestSubstring(a));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s==null||s.length()==0){
            return 0;
        }
        if (s.length()==1){
            return s.length();
        }
        HashMap<Character,Integer> map = new HashMap<>();
        // 定义左右指针
        int leftIndex = 0, rightIndex = 0;
        while (rightIndex<s.length()) {
            char right = s.charAt(rightIndex);
            rightIndex++;
            map.put(right, map.getOrDefault(right, 0)+1);
            while (map.get(right)>1){
                char left = s.charAt(leftIndex);
                leftIndex++;
                map.put(left, map.get(left) - 1);
            }
            res = Math.max(res, rightIndex - leftIndex);
        }
        return res;
    }

}
