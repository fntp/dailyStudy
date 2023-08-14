package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-14  10:48
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230814_1 {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s.next;
        while (p2!=null) {
            if (p2.val ==val) {
                p1.next = p2.next;
                p2 = p2.next;
            }else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head==null){
            return null;
        }
        if (head.val==val){
            return removeElements2(head.next,val);
        }else {
            head.next = removeElements2(head.next,val);
            return head;
        }
    }

}
