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
    public ListNode oddEvenList(ListNode head) {

        if(head== null || head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode curr = head;


        ListNode temp = curr.next;
          ListNode evenHead = temp;

       

        while(temp!= null && temp.next!= null){
            curr.next = temp.next;
            curr = curr.next ;// move odd forward
            temp.next = curr.next;  
            temp = temp.next; // move even forward
        }

        
         curr.next = evenHead; // coonect ood with even

         return prev;
        
    }
}