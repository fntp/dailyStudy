package leetcode2023.dynamicProgramming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.TestPerformance;

/**
 * 检查句子中的数字是否递增
 * 
 * @author fntp
 *
 */
public class Dp001 {
	
	private static final Logger log = LoggerFactory.getLogger(Dp001.class);
	
	public static void main(String[] args) {
		long beginTime = TestPerformance.getBegin();
		boolean areNumbersAscending = areNumbersAscending("hello world 5 x 5");
		log.info(String.format("areNumbersAscending：%s", areNumbersAscending));
		long endTime = TestPerformance.getEnd();
		String usedTimeMillons = TestPerformance.getUsedTimeMillons(beginTime, endTime);
		String usedMemory = TestPerformance.usedMemory(beginTime, endTime);
		log.info(String.format("使用了%s ms，消耗了%s MB内存", usedTimeMillons,usedMemory));
	}
	
	public static boolean areNumbersAscending (String s) {
		int value = 0;
		// 明确说了是用空格进行分割，想到的解决方法就是：直接将字符串进行分割就可以了
		String[] finalArray = s.split(" ");
		// 分割成字符串数组之后开始识别数字
		for (int i = 0; i < finalArray.length; i++) {
			if(finalArray[i].charAt(0) <= '9') {
				int indexValue = Integer.parseInt(finalArray[i]);
				if(indexValue<=value) {
					return false;
				}
				value = indexValue;
			}
		}
		return true;
    }
	
}
