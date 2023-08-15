package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

public class LeetCode20230815_1 {

    public static void main(String[] args) {
        System.out.println(new LeetCode20230815_1().isPalindrome(ListNode.of(1,0,1,1)));
        System.out.println(new LeetCode20230815_1().isPalindrome1(ListNode.of(1,0,1,1)));
        System.out.println(new LeetCode20230815_1().isPalindrome2(ListNode.of(1,0,1,1)));
    }

    /**
     * 优化解法 最优解
     * 两个循环 将两个循环塞入一个while中 优化时间复杂度
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return false;
        }
        if (head.next==null){
            return true;
        }
        ListNode fastIndex = head;
        ListNode lowIndex = head;
        ListNode o1 = head;
        ListNode n1 = null;
        // 快慢指针
        while (fastIndex!=null&&fastIndex.next!=null) {
            lowIndex = lowIndex.next;
            fastIndex = fastIndex.next.next;
            o1.next = n1;
            n1 = o1;
            o1 = lowIndex;
        }
        ListNode newHead = n1;
        if (fastIndex != null){
            lowIndex = lowIndex.next;
        }
        while (newHead != null) {
            if (newHead.val!=lowIndex.val) {
                return false;
            }
            lowIndex = lowIndex.next;
            newHead = newHead.next;
        }
        return true;
    }

    /**
     * 自己的原创写法
     * 两个函数 本质上与第三种写法一致 都是三个while 效率不高
     * @param head xx
     * @return xx
     */
    public boolean isPalindrome1(ListNode head) {
        if(head==null){
            return false;
        }
        if (head.next==null){
            return true;
        }
        // 保存old
        ListNode oldHead = head;
        // 找到中间结点
        ListNode p = findMiddleNode1(head);
        // 然后从中间结点开始翻转 如果翻转的结果与原顺序数一致那么算为回文
        ListNode s = null;
        while (p!=null){
            ListNode cache = p.next;
            p.next = s;
            s = p;
            p = cache;
        }
        while (s!=null) {
            if (oldHead.val!=s.val){
                return false;
            }
            oldHead = oldHead.next;
            s = s.next;
        }
        return true;
    }

    /**
     * 找中间结点
     * @param oldNode xx
     * @return xx
     */
    private ListNode findMiddleNode1(ListNode oldNode) {
        ListNode fastIndex = oldNode;
        ListNode lowIndex = oldNode;
        while (fastIndex!=null&&fastIndex.next!=null) {
            lowIndex = lowIndex.next;
            fastIndex = fastIndex.next.next;
        }
        return lowIndex;
    }

    /**
     * 三种思路三个函数 无优化写法
     * @param head xx
     * @return xx
     */
    public boolean isPalindrome2(ListNode head) {
        if(head==null){
            return false;
        }
        if (head.next==null){
            return true;
        }
        ListNode middleNode = findMiddleNode2(head);
        ListNode newHead = reverse2(middleNode);
        while (newHead != null) {
            if (newHead.val!=head.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode reverse2(ListNode head) {
        ListNode n1 = null;
        while (head!=null) {
            ListNode cache = head.next;
            head.next = n1;
            n1 = head;
            head = cache;
        }
        return n1;
    }

    /**
     * 找中间结点
     * @param oldNode xx
     * @return xx
     */
    private ListNode findMiddleNode2(ListNode oldNode) {
        ListNode fastIndex = oldNode;
        ListNode lowIndex = oldNode;
        while (fastIndex!=null&&fastIndex.next!=null) {
            lowIndex = lowIndex.next;
            fastIndex = fastIndex.next.next;
        }
        return lowIndex;
    }

}
