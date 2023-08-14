package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-14  11:10
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230814_2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        new LeetCode20230814_2().removeNthFromEnd2(head,1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode p = new ListNode(-1,head);
       remove(p, n);
        return p.next;
    }

    public int remove(ListNode head, int n) {
        if (head==null) {
            return 0;
        }
        // 每一个当前节点知道自己下一个节点的序号
        // 这么做有一个破绽：破绽在于最后一个节点只知道自己下一个节点的倒数位置，不知道自己的倒数位置
        int nextNodeLevel = remove(head.next,n) ;
        System.out.println(head.val+"--"+nextNodeLevel);
        if (nextNodeLevel==n) {
            head.next = head.next.next;
        }
        return nextNodeLevel + 1;
    }

    /**
     * 快慢指针法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1,head);
        ListNode slow = sentinel;
        ListNode fast = sentinel;
        // 快慢指针的间距就是需要寻找的第几个的间距 这里是n 那么间距就是n 移动小于n+1个步长 那么就是移动n步
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return sentinel.next;
    }
}
