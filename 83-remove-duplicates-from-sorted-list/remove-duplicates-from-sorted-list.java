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
    public ListNode deleteDuplicates(ListNode node) {
         ListNode head = node ;
        if(node==null){
            return node;
        }
        while(node!= null && node.next!= null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }

            else{
             node =   node.next;
            }
        }

        return head;
    }
}