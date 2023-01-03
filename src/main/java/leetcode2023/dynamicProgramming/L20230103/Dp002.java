package leetcode2023.dynamicProgramming.L20230103;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.TestPerformance;

/**
 * 
 * 动态规划第一天：第二题 最长回文子串
 * 
 * @author fntp
 *
 */
public class Dp002 {
	
	private static final Logger log = LoggerFactory.getLogger(Dp002.class);
	
	public static void main(String[] args) {
		long beginTime = TestPerformance.getBegin();
		String str = longestPalindrome("hello");
		log.info(String.format("回文字符串：%s", str));
		long endTime = TestPerformance.getEnd();
		String usedTimeMillons = TestPerformance.getUsedTimeMillons(beginTime, endTime);
		String usedMemory = TestPerformance.usedMemory(beginTime, endTime);
		log.info(String.format("使用了%s，消耗了%s内存", usedTimeMillons,usedMemory));
	}
	
	public static String longestPalindrome(String s) {
		// 如果目标字符串的长度低于2，那么直接进行
		if(s.length() < 2) {
			return s;
		}
		// 第一步 首先将目标字符串转为字符数组
		char[] charArray = s.toCharArray();
		int startIndex = 0;
		int maxLength = 1;
		for (int i = 0; i < charArray.length-1; i++) {
            for (int j = i+1; j < charArray.length; j++) {
                if (j-i+1>maxLength&&isPalindromeStringOrNot(charArray,i,j)){
                    maxLength = j-i+1;
                    startIndex = i;
                }
            }
        }
		return s.substring(startIndex,startIndex+maxLength);
	}
	
	/**
	 * 
	 * @param charArray 目标字符数组
	 * @param leftIndex 左指针
	 * @param rightIndex 右指针
	 * @return 返回是不是回文字符串的结果
	 */
	private static boolean isPalindromeStringOrNot(char[] charArray,int leftIndex,int rightIndex) {
		while(leftIndex < rightIndex) {
			if(charArray[leftIndex]!=charArray[rightIndex]) {
				return false;
			}
			leftIndex++;
			rightIndex--;
		}
		return true;
	}
	
}
