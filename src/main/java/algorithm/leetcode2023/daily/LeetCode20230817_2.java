package algorithm.leetcode2023.daily;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-18  10:04
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230817_2 {

    public static void main(String[] args) {
        String[] array = {"4","13","5","/","+"};
        System.out.println(new LeetCode20230817_2().evalRPN(array));
    }

    /**
     * 逆波兰表达式
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    Integer number1 = stack.pop();
                    Integer number2 = stack.pop();
                    stack.push(number2+number1);
                }
                case "-" -> {
                    Integer number1 = stack.pop();
                    Integer number2 = stack.pop();
                    stack.push(number2-number1);
                }
                case "*" -> {
                    Integer number1 = stack.pop();
                    Integer number2 = stack.pop();
                    stack.push(number2*number1);
                }
                case "/" -> {
                    Integer number1 = stack.pop();
                    Integer number2 = stack.pop();
                    stack.push(number2/number1);
                }
                default -> {
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }
}
