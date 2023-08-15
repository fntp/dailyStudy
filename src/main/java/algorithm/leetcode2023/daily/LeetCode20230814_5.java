package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-14  16:21
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230814_5 {

    public static void main(String[] args) {

    }

    /**
     * 非递归算法
     * @param p
     * @param q
     * @return
     */
    public ListNode mergeTwoLists(ListNode p, ListNode q) {
        ListNode s = new ListNode(-1,null);
        ListNode header = s;
        while (p!=null&&q!=null) {
            if (p.val>q.val) {
                header.next = q;
                q = q.next;
            }else {
                header.next = p;
                p = p.next;
            }
            header = header.next;
        }
        if (p!=null) {
            header.next = p;
        } else if (q!=null) {
            header.next = q;
        }
        return s.next;
    }

    /**
     * 递归算法
     * @param p
     * @param q
     * @return
     */
    public ListNode mergeTwoLists2(ListNode p, ListNode q) {
        if (p==null) {
            return q;
        }
        if (q==null) {
            return p;
        }
        if (p.val<q.val) {
            p.next = mergeTwoLists2(p.next,q);
            return p;
        }else {
            q.next = mergeTwoLists2(q.next,p);
            return q;
        }
    }
}
