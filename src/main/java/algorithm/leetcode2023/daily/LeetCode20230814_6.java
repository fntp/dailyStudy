package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-14  17:02
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230814_6 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        return mergeSplit(lists,0, lists.length-1);
    }

    /**
     *
     * @param listNodes
     * @param i 左边界
     * @param j 右边界
     * @return
     */
    public ListNode mergeSplit(ListNode[] listNodes,int i, int j){
        if (i==j) {
            // 数组内只有一个链表
            return listNodes[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = mergeSplit(listNodes, i, m);
        ListNode right = mergeSplit(listNodes, m + 1, j);
        return mergeTwoLists(left, right);
    }

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

}
