package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-14  14:50
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230814_4 {

    public static void main(String[] args) {
        System.out.println(new LeetCode20230814_4().deleteDuplicates2(ListNode.of(1, 2, 3, 3, 4, 4, 5)));
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        if (head.val == head.next.val) {
            ListNode next = head.next.next;
            while (next!=null&&next.val==head.val) {
                next = next.next;
            }
            return deleteDuplicates(next);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }

    }

    /**
     * 非递归实现
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        // 头节点
        ListNode sentinel = new ListNode(-1,head);
        // 第一个节点
        ListNode p1 = sentinel;
        // 第二个节点
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        while (p3 != null) {
            if (p2.val==p3.val) {
                while (p3!=null && p3.val==p2.val) {
                    p3 = p3.next;
                }
                p1.next = p3;
                p2 = p1.next;
                p3 = p2.next;
            }else {
                p1 = p1.next;
                p2 = p1.next;
                p3 = p2.next;
            }
        }
        return sentinel.next;
    }

    /**
     * 教程中的非递归写法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates3(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        // 头节点
        ListNode sentinel = new ListNode(-1,head);
        // 第一个节点
        ListNode p1 = sentinel;
        // 第二个节点
        ListNode p2;
        ListNode p3;
        while ((p2 = p1.next)!=null&&(p3=p2.next) != null) {
            if (p2.val==p3.val) {
                while ((p3 = p3.next)!=null && p3.val==p2.val) {
                }
                p1.next = p3;
            }else {
                p1 = p1.next;
            }
        }
        return sentinel.next;
    }


}
