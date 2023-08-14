package algorithm.leetcode2023.daily;
import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-12  17:17
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230812_1 {

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
//        ListNode n1 = new LeetCode20230812_1().reverseList1(o1);
//        ListNode n2 = new LeetCode20230812_1().reverseList2(o1);
//        ListNode n3 = new LeetCode20230812_1().reverseList3(o1);
//          ListNode n4 = new LeetCode20230812_1().reverseList4(o1);
          ListNode n5 = new LeetCode20230812_1().reverseList5(o1);
//        System.out.println(n1);
//        System.out.println(n2);
//        System.out.println(n3);
//        System.out.println(n4);
        System.out.println(n5);
    }

    public ListNode reverseList1(ListNode head) {
        ListNode newHeader = null;
        if (head==null){
            return head;
        }
        while (head!=null) {
            newHeader = new ListNode(head.val, newHeader);
            head = head.next;
        }
        return newHeader;
    }

    public ListNode reverseList2(ListNode head) {
        if (head==null){
            return head;
        }
        LinkedNode newHeader = new LinkedNode(null);
        LinkedNode oldHeader = new LinkedNode(head);
        while (oldHeader.head!=null) {
            newHeader.addFirst(oldHeader.removeFirst());
        }
        return newHeader.head;
    }

    static class LinkedNode {
        ListNode head;

        public LinkedNode (ListNode header) {
            this.head = header;
        }

        public void addFirst(ListNode node) {
            node.next = head;
            head = node;
        }

        public ListNode removeFirst() {
            ListNode firstNode = head;
            if (head!=null){
                head = head.next;
            }
            return firstNode;
        }
    }

    private ListNode reverseList3 (ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode lastNode = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }

    private ListNode reverseList4 (ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode p = head;
        ListNode currentPoint = p.next;
        while (currentPoint!=null) {
            head = currentPoint;
            head.next = p;
            currentPoint = currentPoint.next;
        }
        return head;
    }

    private ListNode reverseList5 (ListNode o1) {
        if (o1==null||o1.next==null) {
            return o1;
        }
        ListNode n1 = null;
        ListNode o2 = o1.next;
        while (o2!=null) {
            o1.next = n1;
            n1 = o1;
            o1 = o2;
            o2 = o1.next;
        }
        o1.next = n1;
        n1 = o1;
        return n1;
    }

}
