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
    public ListNode deleteMiddle(ListNode head) {
        // case: only one node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;   // to track node before slow

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;        // store the previous node
            slow = slow.next;
        }

        // now slow = middle node, prev = node before middle
        prev.next = slow.next;

        return head;
    }
}
