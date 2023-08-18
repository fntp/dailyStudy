package algorithm.leetcode2023.daily;

import java.util.Stack;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-18  09:31
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230817_1 {

    public static void main(String[] args) {
        System.out.println(new LeetCode20230817_1().isValid("()"));
    }

    // 有效的括号
    public boolean isValid(String s) {
        if (s.length()==1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='{') {
                stack.push('}');
            } else if (s.charAt(i)=='[') {
                stack.push(']');
            } else if (s.charAt(i)=='('){
                stack.push(')');
            }else {
                if (!stack.isEmpty()&&s.charAt(i)==stack.peek()) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
