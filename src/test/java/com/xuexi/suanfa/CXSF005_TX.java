package com.xuexi.suanfa;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fntp
 * @since 2024/11/25
 */
public class CXSF005_TX {

    public String largestNumber(int[] nums) {
// 将整数数组转换为字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 使用自定义比较器进行排序
        Arrays.sort(strs, (a, b) -> {
            // 比较两个字符串拼接后的顺序
            int compareRes = (a + b).compareTo(b + a);
            // b + a 大于 a + b，b 在前
            // 相等
            return Integer.compare(0, compareRes); // a + b 大于 b + a，a 在前
        });

        // 如果第一个字符串是"0"，说明所有数字都是0，直接返回"0"
        if (strs[0].equals("0")) {
            return "0";
        }

        // 将排序后的字符串数组拼接成最终结果
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        CXSF005_TX cxsf005_tx = new CXSF005_TX();
        String s = cxsf005_tx.largestNumber(nums);
        System.out.println(s);
    }

}
