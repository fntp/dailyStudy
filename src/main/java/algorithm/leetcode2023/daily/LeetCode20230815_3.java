package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-15  12:18
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230815_3 {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode tu = head;
        ListNode gui = head;
        while (tu!=null&&tu.next!=null) {
            tu = tu.next.next;
            gui = gui.next;
            if (gui==tu) {
               gui = head;
               while (true){
                   // 先判断的目的是：解决当第一次相遇之后 乌龟回到远点之后
                   if (gui==tu){
                       return gui;
                   }
                   gui = gui.next;
                   tu = tu.next;
               }
            }
        }
        return null;
    }
}
