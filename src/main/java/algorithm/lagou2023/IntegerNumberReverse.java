package algorithm.lagou2023;

import lombok.extern.slf4j.Slf4j;

/**
 * 通过数组实现整数翻转
 * 翻转最直接的方法 就是通过逆序
 * 逆序就是将整形数据 转为字符串
 * 在低级版本中
 * @author ys-0303
 *
 * （1） 首位非零
 * （2）
 *
 */
@Slf4j
public class IntegerNumberReverse {


	public static void main(String[] args) {
//		log.info(reverse(1534236469)+"");
		reverse(1534236469);
	}


    private static int reverse(int x) {
		if(x >=Integer.MAX_VALUE || x <= Integer.MIN_VALUE){
			return  0;
		}
    	String xStrValue = String.valueOf(x);
    	if (xStrValue.length()<=1) {
			return x;
		}
    	String flag = "";
    	char[] charArray = xStrValue.toCharArray();
		if (charArray[0]==45){
			flag = "-";
//			log.info("是负数");
		}
		char[] cacheArray = new char[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			cacheArray[i] = charArray[charArray.length-1-i];
		}
		if (flag.length()>0){
			long result = Long.parseLong(flag + new String(cacheArray).replace(flag, ""));
			if (result<Integer.MIN_VALUE){
				return 0;
			}
			return (int) result;
		}else{
			long result = Long.parseLong(new String(cacheArray));
			if (result>Integer.MAX_VALUE){
				return 0;
			}
			return (int) result;
		}
    }
}
