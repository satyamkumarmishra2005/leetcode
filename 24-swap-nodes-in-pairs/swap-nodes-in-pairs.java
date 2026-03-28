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
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode prev = dummy;

        ListNode left = head;


        while(left!= null && left.next!= null){
            ListNode right = left.next;
            ListNode nextleft = left.next.next;

            right.next = left;
            left.next = nextleft ;
            prev.next = right;

            prev = left;
            left = nextleft;
        }

      return dummy.next;



        
    }
}