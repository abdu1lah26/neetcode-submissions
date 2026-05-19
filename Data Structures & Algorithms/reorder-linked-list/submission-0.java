/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode nex = null;
        ListNode curr = slow.next;
        slow.next = null;

        while(curr != null) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        ListNode p1 = head;
        ListNode p2 = prev;

        while(p1 != null && p2 != null) {
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;

            p1.next = p2;
            p2.next = t1;

            p1 = t1;
            p2 = t2;
        }
         return;
    }
}
