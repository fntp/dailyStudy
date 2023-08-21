package algorithm.leetcode2023.daily;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author fntp
 * @since 2023/8/21
 */
public class LeetCode20230821_1 {

    public static void main(String[] args) {

    }

    class MyQueue {

        Stack<Integer> head = new Stack<>();

        Stack<Integer> tail = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            tail.push(x);
        }

        public int pop() {
            if (head.empty()) {
                while (!tail.empty()) {
                    head.push(tail.pop());
                }
            }
           return head.pop();
        }

        public int peek() {
            if (head.empty()) {
                while (!tail.empty()) {
                    head.push(tail.pop());
                }
            }
            return head.peek();
        }

        public boolean empty() {
           return head.isEmpty() && tail.isEmpty();
        }
    }

    class MyStack {

        Queue<Integer> queue = new LinkedList<>();

        int size;

        public MyStack() {
            size = 0;
        }

        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
            size++;
        }

        public int pop() {
            size--;
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return size==0;
        }
    }

}
