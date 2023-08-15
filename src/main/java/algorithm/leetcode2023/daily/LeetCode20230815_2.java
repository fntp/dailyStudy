package algorithm.leetcode2023.daily;

import javabase.datastructure.linkedlist.ListNode;

/**
 * @BelongsProject: dailyStudy
 * @BelongsPackage: algorithm.leetcode2023.daily
 * @Author: fntp
 * @CreateTime: 2023-08-15  12:11
 * @Description: TODO
 * @Version: 1.0
 */
public class LeetCode20230815_2 {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode tu = head;
        ListNode gui = head;
        while (tu!=null&&tu.next!=null) {
            tu = tu.next.next;
            gui = gui.next;
            if (gui==tu) {
                return true;
            }
        }
        return false;
    }



}
