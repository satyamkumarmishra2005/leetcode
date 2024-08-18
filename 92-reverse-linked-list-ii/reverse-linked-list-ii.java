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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftprev = dummy;
        ListNode present = head;

        for(int i = 0 ; i< left-1 ; i++){
            leftprev = leftprev.next;
            present = present.next;
        }
        ListNode prev = null;
        ListNode sequenceHead = present;
    for(int i =0 ; i<= right-left ; i++){
        ListNode next = present.next;
        present.next = prev;
        prev = present;
        present = next;
    }
    leftprev.next = prev;
sequenceHead.next = present;
return dummy.next ;
        
        }
}