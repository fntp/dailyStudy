package algorithm.leetcode2023.daily;

import java.util.Stack;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-18  11:15
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230817_3 {

    public static void main(String[] args) {

    }

    public int calPriority(char value) {
       return switch (value){
            case '*','/'-> 2;
            case '+','-'-> 1;
            case '(' -> 0;
           default -> throw new IllegalArgumentException("参数异常");
       };
    }

    public  String infixToSuffix(String exp) {
        // 用于存储计算符号
        Stack<Character> stack = new Stack<>();
        // 用于存储最后结果
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            switch (exp.charAt(i)) {
                case '+','-','*','/'->{
                    if (stack.isEmpty()) {
                        stack.push(exp.charAt(i));
                    }else {
                        if (calPriority(stack.peek()) < calPriority(exp.charAt(i))) {
                            stack.push(exp.charAt(i));
                        }else {
                            while (!stack.isEmpty()&&calPriority(stack.peek()) >= calPriority(exp.charAt(i))) {
                                builder.append(stack.pop());
                            }
                            stack.push(exp.charAt(i));
                        }
                    }
                }
                // 符号
                case '(',')'->{
                    if (exp.charAt(i)=='('){
                        stack.push(exp.charAt(i));
                    }else {
                        while (!stack.isEmpty()&&stack.peek()!='(') {
                            builder.append(stack.pop());
                        }
                    }
                }
                // 数字
                default -> builder.append(exp.charAt(i));
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                builder.append(stack.pop());
            }
        }
        return builder.toString();
    }
}
