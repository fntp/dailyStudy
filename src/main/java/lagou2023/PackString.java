package lagou2023;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author puye(0303)
 * @since 2023/2/7
 */
public class PackString {

    public static void main(String[] args) {
        new PackString().makeGood("leEeetcode");
    }

    public String makeGood(String s) {
        if (s.length()<=1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int value = Math.abs('s' - 'S');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty()){
                stack.push(aChar);
            }else {
                if (Math.abs(stack.peek() - aChar) == value) {
                    stack.pop();
                }else {
                    stack.push(aChar);
                }
            }
        }
        for (Character character : stack) {
            builder.append(character);
        }
        return builder.toString();
    }
}
