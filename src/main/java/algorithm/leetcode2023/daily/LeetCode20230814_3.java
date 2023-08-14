package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-14  14:17
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230814_3 {

    public static void main(String[] args) {
        ListNode of = ListNode.of(1, 1, 2, 3, 3);
        ListNode listNode = new LeetCode20230814_3().deleteDuplicates(of);
        System.out.println(listNode);
    }

    /**
     * 前后指针法 前后指针需要考虑边界条件
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        while (p2!=null) {
            if (p1.val== p2.val){
                p1.next = p2.next;
                p2 = p1.next;
            }else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        // 我与下一个节点值相同
        if(head.val==head.next.val) {
            return deleteDuplicates2(head.next);
        }else {
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }

}
