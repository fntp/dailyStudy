package algorithm.leetcode2023.daily;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-10  14:36
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230810 {

    public static void main(String[] args) {
        System.out.println(new LeetCode20230810().fib(45));
    }
    public int fib ( int n){
            if (n == 2) {
                int[] result = new int[n];
                result[0] = 0;
                result[1] = 1;
                return result[0] + result[1];
            }
            if (n > 2) {
                int[] result = new int[n + 1];
                result[0] = 0;
                result[1] = 1;
                int Q = 1000000007;
                for (int i = 2; i < result.length; ++i) {
                    result[i] = (result[i - 1] + result[i - 2]) % Q;
                }
                return result[n];
            }
            return n;
        }
}
