package com.xuexi.sf.day01;

/**
 * @author fntp
 * @date 2025/2/13
 * @apiNote
 */
public class ListNode {
    private int val;
    private ListNode next;


    public ListNode(int val) {
        this.val = val;
    }

    public void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        // 前序
        System.out.println(head.val);
        traverse(head.next);
    }

    public void traverse2(ListNode head) {
        if (head == null) {
            return;
        }
        traverse2(head.next);
        // 后序
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        //head.traverse(head);
        head.traverse2(head);
    }
}
