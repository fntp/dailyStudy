package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-14  17:15
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230814_7 {

    public static void main(String[] args) {
        System.out.println(new LeetCode20230814_7().middleNode(ListNode.of(1, 2, 3, 4, 5)));
    }

    /**
     * 快慢指针法
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode fastIndex = head;
        ListNode lowIndex = head;
        while (fastIndex!=null&&fastIndex.next!=null) {
            lowIndex = lowIndex.next;
            fastIndex = fastIndex.next.next;
        }
        return lowIndex;
    }
}
