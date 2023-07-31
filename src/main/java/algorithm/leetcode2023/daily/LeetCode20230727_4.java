package algorithm.leetcode2023.daily;

/**
 * @author fntp
 * @since 2023/7/27
 */
public class LeetCode20230727_4 {

    public static void main(String[] args) {
        LeetCode20230727_4 test = new LeetCode20230727_4();
        System.out.println(test.minInsertions("((()))"));
        System.out.println(test.minInsertions1("((()))"));
    }

    public int minInsertions(String s) {
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }

            if (s.charAt(i) == ')') {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }

        return res + need;
    }

    public int minInsertions1(String s) {
        int leftNumber = 0, rightNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftNumber+=1;
            }else {
                rightNumber+=1;
            }
        }
        return leftNumber * 2 - rightNumber;
    }

}
