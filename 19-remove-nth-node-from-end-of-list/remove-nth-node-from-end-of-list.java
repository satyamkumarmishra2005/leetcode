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
    public ListNode removeNthFromEnd(ListNode head, int n) {

         if (head == null) {
            return null;
        }

        ListNode temp = head;

        int count = 0;

        while(temp!= null){
            temp = temp.next;
            count++;
        }

        if(count== n){

            ListNode newhead = head.next;
            head= null;
            return newhead;
        }

         int res = count-n;

         temp = head;

         while(temp!= null){
            res--;
            if(res== 0){
                break;
            }

            temp = temp.next;
         }



         temp.next = temp.next.next;


         return head;
        
    }
}